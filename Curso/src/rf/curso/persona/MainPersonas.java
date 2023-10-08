package rf.curso.persona;

public class MainPersonas {
	 
public static void main(String[] args) {
    //Creamos una persona
    Persona p = new Persona("001", "Lola Gomez", 19, "600101010");
 
    //Creamos un alumno y lo mostramos.
    String[] asigA = {"IP1", "IP2", "IMD", "CI", "EST"};
    Alumno a = new Alumno("002", "Novatín Chiquitito", 20, "606514458", 2, asigA);
    a.mostrar();
 
    //Cambiamos las asignaturas del alumno y lo mostramos.
    String[] asigB = {"IP1","IP2","CI"};
    a.setAsignaturas(asigB);
    a.mostrar();
 
    //Creamos un profesor
    Profesor pro = new Profesor("003", "Amparo Osuna", 45, "615010250", 1500.50f, "12/03/1990" );
 
    //Mostramos la persona y el profesor.
    p.mostrar();
    pro.mostrar();
 }
}