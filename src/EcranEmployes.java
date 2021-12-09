import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EventObject;

public class EcranEmployes extends JDialog implements CellEditor{
    private JTable tableEmployes = new JTable();




    public void dynamiqueChercher(String cherche){
        //chercher sur le tableau

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


    Object[] columns = {"Id", "Nom", "Prénom", "Département", "Salaire"};
    Object[] rows = new Object[5];

    ActionEmployes actions = new ActionEmployes();


    public EcranEmployes() {

        JFrame jf = new JFrame("Table d'employes");
        jf.setLayout(null);

        //cherche field
        JTextField cherheField = new JTextField("");
        cherheField.setBounds(25,30,450,25);
        cherheField.setSize(450,25);
        cherheField.setLocation(25,30);
        jf.add(cherheField);

        cherheField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String cherche = cherheField.getText();
                dynamiqueChercher(cherche);
            }
        });



        //Separateur
        JSeparator separator = new JSeparator();
        separator.setBounds(25,80, 640,2);
        separator.setForeground(Color.GRAY);
        jf.add(separator);

        //label nom
        JLabel labelNom = new JLabel("Nom : ");
        labelNom.setBounds(25,110,70,25);
        labelNom.setSize(70,25);
        labelNom.setLocation(25,110);
        jf.add(labelNom);

        //textField de nom
        JTextField nomField = new JTextField();
        nomField.setBounds(130, 110, 345,25);
        nomField.setSize(345,25);
        nomField.setLocation(130,110);
        jf.add(nomField);

        //Ajouter button
        JButton ajouterButton = new JButton("Ajouter");
        ajouterButton.setBounds(530,110,100,25);
        ajouterButton.setSize(100,25);
        ajouterButton.setLocation(530, 110);
        jf.add(ajouterButton);



        //label prénom
        JLabel labelPrenom = new JLabel("Prénom : ");
        labelPrenom.setBounds(25,150,70,25);
        labelPrenom.setSize(70,25);
        labelPrenom.setLocation(25,150);
        jf.add(labelPrenom);

        //textField de prénom
        JTextField prenomField = new JTextField();
        prenomField.setBounds(130, 150, 345,25);
        prenomField.setSize(345,25);
        prenomField.setLocation(130,150);
        jf.add(prenomField);

        //label département
        JLabel labelDepartement = new JLabel("Département : ");
        labelDepartement.setBounds(25,190,90,25);
        labelDepartement.setSize(90,25);
        labelDepartement.setLocation(25,190);
        jf.add(labelDepartement);

        //textField de département
        JTextField departementField = new JTextField();
        departementField.setBounds(130, 190, 345,25);
        departementField.setSize(345,25);
        departementField.setLocation(130,190);
        jf.add(departementField);

        //label salaire
        JLabel labelSalaire = new JLabel("Salaire : ");
        labelSalaire.setBounds(25,230,90,25);
        labelSalaire.setSize(90,25);
        labelSalaire.setLocation(25,230);
        jf.add(labelSalaire);

        //textField de salaire
        JTextField salaireField = new JTextField();
        salaireField.setBounds(130, 230, 345,25);
        salaireField.setSize(345,25);
        salaireField.setLocation(130,230);
        jf.add(salaireField);

        //label message
        JLabel messageLabel = new JLabel("");
        messageLabel.setBounds(25,270,620,25);
        messageLabel.setSize(620,25);;
        messageLabel.setLocation(25,270);
        messageLabel.setForeground(Color.RED);
        jf.add(messageLabel);




        //tableau
        modelim.setColumnIdentifiers(columns);


        JScrollPane sp = new JScrollPane();
        sp.setSize(650,500);
        sp.setLocation(25,300);
        sp.setViewportView(tableEmployes);

        jf.add(sp);
        ajouteTable();

        jf.setSize(700,850);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        //ajouter button action
        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = nomField.getText();
                String prenom = prenomField.getText();
                String departement = departementField.getText();
                String salaire = salaireField.getText();

                actions.ajoutePersonne(nom, prenom, departement, salaire);

                ajouteTable();

                messageLabel.setText("Nouvel employé ajouté avec succès");
            }
        });

    }
    //ajouter à table
    public void ajouteTable(){
        ResultSet rs = actions.yap();


        try {
            while (rs.next()){
                rows[0] = rs.getString("id");
                rows[1] = rs.getString("soyad");
                rows[2] = rs.getString("ad");
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

    public static void main(String[] args) {
        new EcranEmployes();
    }


}


