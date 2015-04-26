/*
 * Copyright (C) 2015 UTN-FRRe
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ar.edu.utn.frre.dacs.persistencia.jpa.model.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import ar.edu.utn.frre.dacs.persistencia.jpa.model.Sexo;

/**
 * <h2>Validador de CUIT/CUIL.</h2> Valida que el CUIT/CUIL posea un formato
 * correcto.
 *
 * @author <a href="mailto:jorge.villaverde@nbch.com.ar">Jorge E. Villaverde</a>
 * @version 1.0.0
 * @since 1.0.0
 */
public class CUITValidator implements ConstraintValidator<CUIT, Long> {

    // Properties --------------------------------------------------------------

    @SuppressWarnings("unused")
    private CUIT cuit;

    // Overrides ---------------------------------------------------------------

    @Override
    public void initialize(CUIT cuit) {
        this.cuit = cuit;
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        boolean isValid = false;

        String cuitValue = value.toString();

        if (cuitValue.length() == 11) {
            String type = cuitValue.substring(0, 2);
            String dni = cuitValue.substring(2, 10);
            String dv = cuitValue.substring(10, 11);
            try {

                Integer nType = Integer.parseInt(type);

                if ((nType == 20 || nType == 23 || nType == 27 || nType == 30)) {

                    Long lDni = Long.parseLong(dni);

                    if (lDni > 0) {
                        Integer nDV = Integer.parseInt(dv);

                        int digitoVerificador = calcularDigitoVerificador(cuitValue);

                        if (nDV.equals(digitoVerificador)) {
                            isValid = true;
                        }
                    }
                }
            } catch (NumberFormatException ne) {
                return false;
            }
        }
        return isValid;
    }

    // Actions -----------------------------------------------------------------

    private static int calcularDigitoVerificador(String cuit) {
        int multiplicador = 2;
        int acumulado = 0;

        for (int i = 9; i >= 0; i--) {

            int posValue = Integer.parseInt(cuit.substring(i, i + 1));

            acumulado += posValue * multiplicador;

            multiplicador++;

            if (multiplicador > 7) {
                multiplicador = 2;
            }
        }

        int suma11 = 11 - (acumulado % 11);

        if (suma11 == 11) {
            return 0;
        }

        if (suma11 == 10) {
            return 9;
        }

        return suma11;
    }

    /**
     * Calcula el CUIT/CUIL para una Persona F&iacute;sica.
     * @param sexo Sexo de la persona
     * @param numeroDocumento nro del documento.
     * @return CUIT/CUIL
     */
    public static Long calcularCuitPersonaFisica(Sexo sexo, long numeroDocumento) {
        int sexoVal = 24;

        if (Sexo.M.equals(sexo)) {
            sexoVal = 20;
        } else if (Sexo.F.equals(sexo)) {
            sexoVal = 27;
        }

        String cuit = String.format("%02d%08d", sexoVal, numeroDocumento);

        int digitoVerificador = calcularDigitoVerificador(cuit);

        return Long.parseLong(String.format("%s%d", cuit, digitoVerificador));
    }
}

