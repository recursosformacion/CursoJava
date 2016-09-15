package rf.curso.persona;

public class Persona {
	private String codPersona;
    private String nombre;
    private int edad;
    private String telContacto;
 
    //Constructor
    public Persona(String codPersona, String nombre, int edad, String telContacto){
        this.codPersona = codPersona;
        this.nombre = nombre;
        this.edad = edad;
        this.telContacto = telContacto;
    }
 
    //Getters y Setters
    public String getCodPersona(){
        return codPersona;
    }
    public void setCodPersona(String codPersona){
        this.codPersona = codPersona;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public int getEdad(){
        return edad;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    public String getTelContacto(){
        return telContacto;
    }
    public void setTelContacto(String telContacto){
        this.telContacto = telContacto;
    }
 
    //Métodos
    public void mostrar(){
         System.out.println("Persona: " + codPersona + "-" + nombre + "\n Edad: " + edad + "\n TelContacto: " + telContacto + "\n");
    }

}
