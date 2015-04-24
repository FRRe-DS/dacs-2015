/**
 *    Copyright 2012 
 *    Facultad Regional Resistencia 
 *    Universidad Tecnológica Nacional
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/
package ar.edu.utn.frre.cs.model.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * <h2>Definici&oacute;n</h2>
 * <p>
 * La Clave Unica de Identificaci&oacute;n Tributaria (CUIT) 
 * es una clave &uacute;nica que se utiliza en el sistema tributario 
 * argentino para poder identificar inequ&eacute;vocamente a las personas f&iacute;sicas o 
 * jur&iacute;dica aut&oacute;nomas, susceptible de tributar. Es asignada por la 
 * <a href="http://www.afip.gov.ar/">Administraci&oacute;n Federal de Ingresos P&uacute;blicos</a>, 
 * para poder confeccionar el registro o censo de las mismas, 
 * para efectos administrativo-tributarios.
 * </p>
 * <br/>
 * <p>
 * <h2>Composici&oacute;n</h2><br/>
 * Consta de un total de once (11) cifras: dos dígitos iniciales que indican el tipo 
 * global, seguido por ocho dígitos que corresponden, en el caso de personas físicas, 
 * al número de Documento Nacional de Identidad, y en el caso de empresas a un 
 * número de sociedad asignado por la AFIP, y finalmente un dígito verificador.
 * </p>
 * <h2>Procedimiento para obtener el dígito verificador</h2>
 * <p>
 * El CUIT o CUIL consta de tres partes, el tipo, el número y el dígito 
 * verificador separados por guión. En el siguiente ejemplo se toma como CUIT el 
 * número ##-12345678-X, donde ## es el tipo, 12345678 es el número de DNI o 
 * numero de sociedad y X es el dígito verificador.
 * </p>
 * <p>
 * <b>Tipo</b>: Físicas (Hombres, Mujeres) o Jurídicas
 * <ul>
 * <li><b>27</b> significa que es mujer</li>
 * <li><b>20</b> significa que es hombre</li>
 * <li><b>23</b> puede ser ambos</li>
 * <li><b>30</b> significa que es empresa</li>
 * </ul> 
 * </p>
 * <p>
 * Para obtener el dígito verificador que no conocemos o que queremos calcular:
 * <ul>
 * <li>
 * Se procede a tomar el número de 10 digitos compuesto por los 2 primeros mas 
 * los 8 digitos siguientes, de derecha a izquierda, multiplicando cada dígito 
 * por los números que componen la serie numérica 2,3,4,5,6,7; y sumando el 
 * resultado de estos productos, como se muestra a continuación (si se ha 
 * aplicado la serie hasta el 7 y quedan dígitos por multiplicar, se comienza 
 * la serie nuevamente).
 * </li>
 * <li>
 * Al número obtenido por la suma del producto de cada dígito por la serie ya 
 * mencionada, se le aplica módulo 11, o sea, se divide por 11 y se determina 
 * el resto de la división.
 * </li>
 * <li>Ahora se hace 11 menos SUMA_MOD11</li>
 * 	<ul>
 *    <li>Si el resultado es 11, el dígito verificador será 0.</li>
 *    <li>Si el resultado es 10, el dígito verificador será 9.</li>
 *    <li>En otro caso el resultado será el dígito verificador.</li>
 *  </ul>
 * </ul>
 * </p>
 * @author Jorge E. Villaverde
 * @version 1.0.0
 * @date 21/06/2011  
 */
//@NotNull
//@Size(min=11, max=11)
@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = CUITValidator.class)
@Documented
public @interface CUIT {
	String message() default "{ar.edu.utn.frre.cs.model.constraints.CUIT.message}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};	
}