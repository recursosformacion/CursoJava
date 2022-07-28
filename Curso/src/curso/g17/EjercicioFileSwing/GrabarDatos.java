package curso.g17.EjercicioFileSwing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

public class GrabarDatos {

	private FileWriter fichero = null;
	private PrintWriter pw = null;

	public boolean prepara() {
		final JFileChooser fc = new JFileChooser();
		fc.setMultiSelectionEnabled(true);
		fc.setCurrentDirectory(new File("C:"));
		int retval = fc.showSaveDialog(null);
		if (retval == JFileChooser.APPROVE_OPTION) {
			try {
				fichero = new FileWriter(fc.getSelectedFile(), false);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			pw = new PrintWriter(fichero);
			return true;
		}
		return false;
	}

	public boolean graba(String str) {

		pw.println(str);

		return true;
	}

	public void close() {
		try {
			if (null != fichero)
				fichero.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}

	public void finalize() {
		close();
		try {
			super.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
