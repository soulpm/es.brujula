# BRUJULA.ES - PRUEBA JAVA #

Dado el siguiente diagrama UML:
![Diagram.png](https://bitbucket.org/repo/oLqA9Kg/images/1155802627-Diagram.png)

Se requiere crear las clases, variables y métodos para modelar el diagrama. Además se desea el siguiente comportamiento:

* Como es habitual, no se han referenciado en el diagrama los métodos **getters y setters** de los atributos de cada clase.
* El método **list()** deberá generar una Lista con los profesores del departamento en orden alfabético, según su apellido.
* El método **addProfessor(Professor)** no podrá añadir dos profesores repetidos, para ello deberemos contemplar Nombre y Apellidos del profesor.
* El método **addProfessor(Professor)** deberá comprobar también que los campos Department y DepartmentName coinciden.
* Si se crea un **ActingProfessor**, con fecha de fin menor a la actual, deberá lanzarse la excepción correspondiente y manejarse apropiadamente lanzándose por la salida del sistema apropiada.
* El método **getCompleteName()** deberá componer el nombre y apellidos del profesor en el orden: “apellidos, nombre”
* El método **getAge()** deberá calcular la edad de la persona y devolverla como entero.
* Cualquier parámetro de tipo texto, no deberá sobrepasar los 20 caracteres, ni estar vacíos. En otro caso se espera una excepción.

Para controlar estos comportamientos se da el armazón del proyecto en este repositorio el en el cual existe una clase con ciertos *Unit Tests* los cuales **deberán pasar correctamente.**

# Instrucciones de entrega #
Se pide seguir los siguientes pasos para la entrega de la prueba:

1. Crear la solución compilable y adecuada a las restricciones indicadas.
2. Ejecutar desde la consola de comandos "mvn clean" desde el directorio raíz de la prueba.
3. Empaquetar en un zip la carpeta con el código de la solución y enviar a [rrhh@brujula.es](mailto:rrhh@brujula.es)