package curso.g9900.BBDD0;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

public class ListCountries extends JFrame {

	public final static String SELECT_1 = "SELECT * FROM COUNTRIES ";
	// Table for user data
    private JTable userTable;
    // table column
    private String[] userTableColumn = {"Id", "Nombre", "Region"};

    // back button
    private JButton backButton;

    public ListCountries() {
        // uses box layout
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        // toolbar for buttons
        JToolBar toolBar = new JToolBar();
        userTable = new JTable();
        // scroll bar for table
        JScrollPane userTableScroll = new JScrollPane(userTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        backButton = new JButton("Go Back");
        add(toolBar);
        toolBar.add(backButton);
        toolBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, toolBar.getMinimumSize().height));
        add(userTableScroll);

    }

    // gets users from database and loads to table
    public void getCountries(Object[] objects) {
    		OracleJDBC ojdbc = OracleJDBC.getInstance();
    		ResultSet rs = ojdbc.ejecutarQuery(SELECT_1);
    		while (rs.next()) {
    			
    		}

    }

    // event listener for back button
    public void backButton(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }
}
