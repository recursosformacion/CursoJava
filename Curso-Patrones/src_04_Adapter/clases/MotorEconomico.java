

package clases;


/**
 * Clase del aplicativo que cuenta con metodos afines a los de la clase
 * a adaptar, esta se comunica con la nueva clase mediante el patron adapter
 * @author chenao
 *
 */
public class MotorEconomico extends Motor {

    public MotorEconomico(){
        super();
        System.out.println("Creando motor economico");
    }

    @Override
    public void encender() {
        System.out.println("Encendiendo motor economico.");
    }

    @Override
    public void acelerar() {
        System.out.println("Acelerando motor economico.");
    }

    @Override
    public void apagar() {
        System.out.println("Apagando motor economico.");
    }


}
