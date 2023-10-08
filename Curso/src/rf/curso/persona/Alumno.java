package rf.curso.persona;

public class Alumno extends Persona{
    private int curso;
    private String[] asignaturas;
 
    //Constructor
    public Alumno(String codPersona, String nombre, int edad, String telContacto,int curso, String[]asignaturas){
        super(codPersona, nombre, edad, telContacto);
        this.curso = curso;
        this.asignaturas = asignaturas;
    }
 
    //Getters y Setters
    public int getCurso(){
        return curso;
    }
 
    public void setCurso(int curso){
        this.curso = curso;
    }
    public String[] getAsignaturas(){
        return asignaturas;
    }
    public String AsignaturasToString(){
        String resultado = "Asignaturas: ";
        for (int i=0; i<asignaturas.length; i ++)
        {
             if (i == 0){
                 resultado = resultado + asignaturas[i];
             }
             else {
                 resultado = resultado + ", " + asignaturas[i];
             }
        }
        return resultado;
    }
 
    public void setAsignaturas(String []asignaturas){
         this.asignaturas = asignaturas;
    }
 
    //Métodos
    public void mostrar(){
        System.out.println("Alumno: " + getNombre() + "\n Curso: " + curso + " " +  AsignaturasToString() + "\n");
    }
}
