import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EventObject;

public class EcranEmployes extends JDialog implements CellEditor{
    private JTable tableEmployes = new JTable();
    private JPanel panel1;
    private JButton button1;
    private JTextField chercher;










    public void dynamiqueChercher(String cherche){
        TableRowSorter<DefaultTableModel> tr =new TableRowSorter<DefaultTableModel>(modelim);
        tableEmployes.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(cherche));
    }

    DefaultTableModel modelim = new DefaultTableModel();

    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public boolean isCellEditable(EventObject anEvent) {
        return false;
    }

    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        return false;
    }

    @Override
    public boolean stopCellEditing() {
        return false;
    }

    @Override
    public void cancelCellEditing() {

    }

    @Override
    public void addCellEditorListener(CellEditorListener l) {

    }

    @Override
    public void removeCellEditorListener(CellEditorListener l) {

    }


    Object[] columns = {"id", "prénom", "nom", "departement", "salaire"};
    Object[] rows = new Object[5];

    ActionEmployes actions = new ActionEmployes();


    public EcranEmployes() {

        JFrame jf = new JFrame("Table d'employes");
        jf.setLayout(null);

        JTextField cherheField = new JTextField("");
        cherheField.setBounds(25,20,450,30);
        cherheField.setSize(450,30);
        cherheField.setLocation(25,20);
        jf.add(cherheField);


        JButton chercheButton = new JButton("Cherche");
        chercheButton.setBounds(530,20,100,30);
        chercheButton.setSize(100,30);
        chercheButton.setLocation(530, 20);


        jf.add(chercheButton);

        modelim.setColumnIdentifiers(columns);


        JScrollPane sp = new JScrollPane();
        sp.setSize(650,500);
        sp.setLocation(25,100);
        sp.setViewportView(tableEmployes);

        jf.add(sp);


        jf.setSize(700,650);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ResultSet rs = actions.yap();


        try {
            while (rs.next()){
                rows[0] = rs.getString("id");
                rows[1] = rs.getString("ad");
                rows[2] = rs.getString("soyad");
                rows[3] = rs.getString("departman");
                rows[4] = rs.getString("maas");
                modelim.addRow(rows);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }



        tableEmployes.setEnabled(false);
        tableEmployes.setModel(modelim);

    }



}

