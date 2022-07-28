package curso.g50.sonido;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
 
public class BotonSonido extends JFrame implements ActionListener{
    JButton boton1 = new JButton("Pulsame");
    public BotonSonido(){
        super("Pulse el boton");
        setSize(400,80);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(boton1);
        boton1.addActionListener(this);
        setVisible(true);
    }
    public static void main(String[] Dar10){
        new BotonSonido();
    }
    public void ReproducirSonido(String nombreSonido){
       try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
       } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
         System.out.println("Error al reproducir el sonido.");
       }
     }
    @Override
    public void actionPerformed(ActionEvent e) {
    	String sCarpAct = System.getProperty("user.dir");
		String direc=sCarpAct + "/src/curso/g50/sonido/";
        if(e.getSource() == boton1){
            ReproducirSonido(direc + "MachineGunShells.mp3");
        }
    }
}