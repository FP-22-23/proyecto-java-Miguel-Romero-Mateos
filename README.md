# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  2022/2023)
Autor/a: Miguel Romero Mateos  uvus: KPH6911

PRIMERA ENTREGA: 12/3/2023

Aquí debes añadir la descripción del dataset y un enunciado del dominio del proyecto.

## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **fp.stackoverflow**: Paquete que contiene los tipos del proyecto.
  * **fp.stackoverflow.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset o datasets del proyecto
    * **survey_results_public.csv**: Dataset con miles de registros sobre preguntas realizadas en una encuesta a usuarios de StackOverflow.
    
## Estructura del *dataset*

Aquí debes describir la estructura del dataset explicando qué representan los datos que contiene y la descripción de cada una de las columnas. Incluye también la URL del dataset original.

El dataset está compuesto por 154 columnas, con la siguiente descripción: (describiré las 8 usadas)

* **Respondent**: de tipo Integer, representa la posición del usuario en la encuesta realizada (es una manera de contar la cantidad de usuarios que han realizado la encuesta).
* **Professional**: de tipo String, representa el estatus actual del usuario respecto a su carrera profesional.
* **Country**: de tipo String, representa la nacionalidad del usuario.
* **EmploymentStatus**: de tipo String, representa el estatus actual del usuario respecto a su empleo.
* **University**: de tipo String, representa si el usuario ha cursado estudios universitarios.
* **Salary**: de tipo Double, representa el salario actual del usuario.
* **ExpectedSalary**: de tipo Double, representa el salario deseado del usuario.
* **CompanySize**: de tipo String, representa el volumen de la empresa para la que trabaja el usuario (si procede).


## Tipos implementados

Describe aquí los tipos que usas en tu proyecto.

### Tipo Base
Descripción breve del tipo base.

**Propiedades**:

- posicion, de tipo Integer, consultable. 
- statusprof, de tipo StatusProfesional, consultable y modificable. 
- nacionalidad, de tipo String, consultable y modificable.
- statusemp, de tipo StatusEmpleo, consultable y modificable.
- estudiosuniversitarios, de tipo String, consultable y modificable.
- salarioactual, de tipo Double, consultable y modificable.
- salariodeseado, de tipo Double, consultable y modificable.
- volumenempresa, de tipo String, consultable y modificable.

**Constructores**: 

- C1: El primer constructor toma todas las propiedades.
- C2: El segundo constructor toma las propiedades de posicion, salarioactual y salariodeseado.

**Restricciones**:
 
- R1: La primera restricción consiste en que la posición no puede ser negativa.
- R2: La segundo restricción consiste en que la nacionalidad no puede ser nula.

**Criterio de igualdad**: La función critIgual devolverá "true" exclusivamente si las posiciones de los usuarios son la misma (es decir, que estamos ante el mismo encuestado).

**Criterio de ordenación**: No lo hay.

**Otras operaciones**:
 
- O1: La operación diferenciasalario calcula la diferencia entre el salario deseado y el salario actual del encuestado.
- O2: La operación getNumeroElementos calcula el total de elementos que se encuentran en un contenedor.
- O3: La operación añadirElemento añade un elemento nuevo al contenedor.
- O4: La operación añadirColección añade una colección dada al contenedor.
- O5: La operación eliminarElemento elimina un elemento del contenedor.

#### Tipos auxiliares (no procede)

Descripción de los tipos auxiliares que sean necesarios añadir al proyecto.

### Factoría

Descripción breve de la factoría.

- Método 1: El primer método de la factoría genera un Objeto del tipo StackOverflow en el que figuran todos los valores del CSV parseados.
-	Método 2: El segundo método de la factoría genera una Lista de objetos en la que figuran todos los valores del CSV parseados.

### Tipo Contenedor

Descripción breve del tipo contenedor.

**Propiedades**:

- datos, de tipo List<StackOverflow>, consultable.
- ...

**Constructores**: 

- C1: El primer constructor simplemente genera una lista preparada para almacenar datos.
- C2: El segundo constructor genera una lista que contiene los datos de una colección dada.
- ...

**Restricciones**: (no procede)
 
- R1: Descripción de la restricción 1.
- R2: Descripción de la restricción 2.
- ...
- 
**Criterio de igualdad**: El criterio de igualdad compara el hashCode de la propiedad datos y comprueba si coincide con el hashCode de los objetos que la conforman.

**Criterio de ordenación**: No lo hay.

**Otras operaciones**:
 
-	_método 1_: Descripción del método 1.
- ...