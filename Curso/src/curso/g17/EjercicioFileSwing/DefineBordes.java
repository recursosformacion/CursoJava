package curso.g17.EjercicioFileSwing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

public class DefineBordes {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Prueba bordes");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				System.exit(0);
			}

		});

		frame.getContentPane().add(new java1402(), BorderLayout.CENTER);
		frame.setSize(500, 300);
		frame.setVisible(true);
	}

	static JPanel creaBorde(Border b) {
		JPanel panel = new JPanel();
		String str = b.getClass().toString();

		str = str.substring(str.lastIndexOf('.') + 1);
		panel.setLayout(new BorderLayout());
		panel.add(new JLabel(str, JLabel.CENTER), BorderLayout.CENTER);
		panel.setBorder(b);

		return (panel);
	}

	}

	public java1402() {
        setLayout( new GridLayout( 2,4 ) );
        add( creaBorde( new TitledBorder("Titulo") ) );
        add( creaBorde( new EtchedBorder() ) );
        add( creaBorde( new LineBorder(Color.blue) ) );
        add( creaBorde( new MatteBorder(5,5,30,30,Color.green) ) );
        add( creaBorde( new BevelBorder(BevelBorder.RAISED) ) );
        add( creaBorde( new SoftBevelBorder(BevelBorder.LOWERED) ) );
        add(creaBorde(new CompoundBorder(
          new EtchedBorder(),new LineBorder(Color.red) ) ) );
      }

}
