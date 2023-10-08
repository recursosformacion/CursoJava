package rf.curso.persona;

public class Profesor extends Persona {

	private float salario;
	private String fecContratacion;

	// Constructor
	public Profesor(String codPersona, String nombre, int edad, String telContacto, float salario,
			String fecContratacion) {
		super(codPersona, nombre, edad, telContacto);
		this.salario = salario;
		this.fecContratacion = fecContratacion;
	}

	// Getters y Setters
	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getFecContratacion() {
		return fecContratacion;
	}

	public void setFecContratacion(String fecContratacion) {
		this.fecContratacion = fecContratacion;
	}

	// Métodos
	public void mostrar() {
		System.out.println("Profesor: " + getNombre() + "\n Salario: " + salario + "\n FecContratacion: "
				+ fecContratacion + "\n");
	}

}
