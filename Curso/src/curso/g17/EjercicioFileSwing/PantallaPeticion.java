package curso.g17.EjercicioFileSwing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

public class PantallaPeticion extends JFrame implements ActionListener {

	private int contador = 0; 					// contador usuario
	private Object data[][] = new Object[0][2]; // area de datos pata JTable
	private JLabel lblNombre; 					// etiqueta o texto no editable
	private JTextField txtNombre; 				// caja de texto, para insertar datos
	private JButton btAdd, btGrabar;			 // botones
	private JTable jt;							// tabla de datos
	DefaultTableModel dmodel;

	/******************************** Literales ******************************/
	public static final String column[] = { "ID", "Nombre" };
	public static final String LABEL_NOMBRE = "Nombre";
	public static final String BT_ENVIAR = "Enviar";
	public static final String BT_GRABAR = "Grabar";
	public static final String TITULO = "Entrada usuarios";
	public static final String ERROR_LONGITUD = "El campo ha de tener 5 caracteres como minimo";

	PantallaPeticion() {
		super(); 								// usamos el contructor de la clase padre JFrame
		configurarVentana(); 					// configuramos la ventana
	}

	private void configurarVentana() {
		setTitle(TITULO);
		Container contentPane = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,600);
		setLocationRelativeTo(null);
		SpringLayout layout = new SpringLayout();
		contentPane.setLayout(layout); 			// establece el layout

		// creamos los componentes
		lblNombre = new JLabel(LABEL_NOMBRE);
		txtNombre = new JTextField(30);
		txtNombre.setHorizontalAlignment(JTextField.LEFT);
		lblNombre.setLabelFor(txtNombre);

		btAdd = new JButton(BT_ENVIAR);
		btAdd.setName(BT_ENVIAR);
		btAdd.addActionListener(this);			//registramos la porpia clase como Listener para Enviar
		btGrabar = new JButton(BT_GRABAR);
		btGrabar.setName(BT_GRABAR);
		btGrabar.addActionListener(this);		//registramos la porpia clase como Listener para Grabar

		// Definicion y configuracion de JTable
		dmodel = new DefaultTableModel(data, column);
		jt = new JTable(dmodel);
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jt.getColumnModel().getColumn(0).setPreferredWidth(50);     //Definimos la anchura de columna de ID
		jt.getColumnModel().getColumn(1).setPreferredWidth(400);    //Definimos la anchura de columna de Nombre
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		JScrollPane sp = new JScrollPane(jt);						//cargamos la JTable dentro de un JScrollPane

		// adicionamos los componentes a la ventana
		contentPane.add(lblNombre);
		contentPane.add(txtNombre);
		contentPane.add(btAdd);
		contentPane.add(btGrabar);
		contentPane.add(sp);

		//posicionamos todos los componentes
		layout.putConstraint(SpringLayout.WEST, txtNombre, 70, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, txtNombre, 10, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.WEST, lblNombre, 5, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, lblNombre, 0, SpringLayout.NORTH, txtNombre);
		layout.putConstraint(SpringLayout.WEST, btAdd, 10, SpringLayout.EAST, txtNombre);
		layout.putConstraint(SpringLayout.NORTH, btAdd, 0, SpringLayout.NORTH, txtNombre);
		layout.putConstraint(SpringLayout.WEST, sp, 0, SpringLayout.WEST, lblNombre);
		layout.putConstraint(SpringLayout.NORTH, sp, 10, SpringLayout.SOUTH, txtNombre);
		layout.putConstraint(SpringLayout.SOUTH, btGrabar, -20, SpringLayout.SOUTH, contentPane);
		layout.putConstraint(SpringLayout.EAST, btGrabar, -20, SpringLayout.EAST, contentPane);
	}

	/**
	 * Definicion de las funcionalidades del Listener.
	 * Atiende eventos de los dos botones, identifica cual se ha pulsado
	 * y llama a los métodos necesarios
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {
		JButton o = (JButton) ev.getSource();
		String boton = o.getName();
		if (boton.equals(BT_ENVIAR)) {
			if (addToRow()) {
				jt.repaint();
				txtNombre.setText("");
			}
			txtNombre.requestFocusInWindow();
		}
		if (boton.equals(BT_GRABAR)) {
			String datos[][] = leerDatos(jt);
			grabar(datos);
			System.exit(0);
			
		}
	}

	/**
	 * Añadir datos a fila de JTable
	 */
	public boolean addToRow() {
		String valor = txtNombre.getText(); // obtenemos el contenido de la
		if (valor.length() >= 5) {
			Object[] datos = new Object[2];
			datos[0] = ++contador;
			datos[1] = valor;
			dmodel.addRow(datos);
			return true;
		}
		JOptionPane.showMessageDialog(this, ERROR_LONGITUD,"Verificacion",JOptionPane.ERROR_MESSAGE);
		return false;
	}

	/**
	 * Extrae informacion de un objeto JTable que contiene Strings
	 * 
	 * @param jt
	 *            Objeto de donde extraer la informacion
	 * @return Array de String de dos dimensiones en donde se deja la
	 *         informacion
	 */
	public String[][] leerDatos(JTable jt) {
		if (jt == null)
			return null;
		int rowCount = jt.getRowCount();
		int colCount = jt.getColumnCount();
		String salida[][] = new String[rowCount][colCount];
		for (int row = 0; row < rowCount; row++) {
			for (int col = 0; col < colCount; col++) {
				salida[row][col] = (String) (jt.getValueAt(row, col)+"");
			}
		}
		
		return salida;
	}

	/**
	 * Graba el elemento 1 de todas las lineas del Array
	 * @param str Array a grabar
	 */
	public void grabar(String[][] str){
		GrabarDatos gDatos = new GrabarDatos();
		if (gDatos.prepara()) {
			for (int a = 0; a < str.length; a++) {
				gDatos.graba(str[a][1]);
			}
			gDatos.close();
		}
	}
	
	public static void main(String[] args) {
		PantallaPeticion V = new PantallaPeticion(); // creamos una ventana
		V.setVisible(true); // hacemos visible la ventana creada
	}
}
