import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EcranEmployes extends JFrame {
    private JTable tableEmployes = new JTable();




    public void dynamiqueChercher(String cherche){
        //chercher sur le tableau

        TableRowSorter<DefaultTableModel> tr =new TableRowSorter<DefaultTableModel>(modelim);
        tableEmployes.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(cherche));
    }

    DefaultTableModel modelim = new DefaultTableModel() {
      public boolean isCellEditable(int row, int column) {
            return false;
        }
    };



    Object[] columns = {"Id", "Nom", "Prénom", "Département", "Salaire"};
    Object[] rows = new Object[5];

    ActionEmployes actions = new ActionEmployes();


    public EcranEmployes() {
        JFrame frame = new JFrame("Table d'employes");
        JPanel jf = new JPanel();
        frame.add(jf);
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

        //Modifier button
        JButton modifierButton = new JButton("Modifier");
        modifierButton.setBounds(530,150,100,25);
        modifierButton.setSize(100,25);
        modifierButton.setLocation(530, 150);
        jf.add(modifierButton);

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

        //Supprimer button
        JButton supprimerButton = new JButton("Supprimer");
        supprimerButton.setBounds(530,190,100,25);
        supprimerButton.setSize(100,25);
        supprimerButton.setLocation(530, 190);
        jf.add(supprimerButton);

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

        frame.setSize(700,850);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //ajouter button action
        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = nomField.getText();
                String prenom = prenomField.getText();
                String departement = departementField.getText();
                String salaire = salaireField.getText();

                if (nom.equals("") | prenom.equals("") | departement.equals("") | salaire.equals("")){
                    messageLabel.setText("Veuillez saisir les informations complètes");
                }
                else {

                    actions.ajoutePersonne(nom, prenom, departement, salaire);

                    modelim.getDataVector().removeAllElements();
                    modelim.fireTableDataChanged();
                    ajouteTable();

                    messageLabel.setText("Nouvel employé ajouté avec succès");

                    nomField.setText("");
                    prenomField.setText("");
                    departementField.setText("");
                    salaireField.setText("");
                }
            }
        });

        //quand on click sur la table
        tableEmployes.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedrow = tableEmployes.getSelectedRow();
                nomField.setText(tableEmployes.getValueAt(selectedrow,1).toString());
                prenomField.setText(tableEmployes.getValueAt(selectedrow,2).toString());
                departementField.setText(tableEmployes.getValueAt(selectedrow,3).toString());
                salaireField.setText(tableEmployes.getValueAt(selectedrow,4).toString());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        //modifier button action
        modifierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = nomField.getText();
                String prenom = prenomField.getText();
                String departement = departementField.getText();
                String salaire = salaireField.getText();
                int selectedRow = tableEmployes.getSelectedRow();



                if (selectedRow == -1){
                    if (modelim.getRowCount() == 0){
                        messageLabel.setText("Le tableau est actuellement vide");
                    }
                    else {
                        messageLabel.setText("Veuillez sélectionner l'employé que vous souhaitez mettre à jour");
                    }
                }
                else{
                    String string = modelim.getValueAt(selectedRow,0).toString();
                    int id = Integer.parseInt(string);
                    actions.metJourEmployes(id,nom,prenom,departement,salaire);

                    modelim.getDataVector().removeAllElements();
                    modelim.fireTableDataChanged();
                    ajouteTable();

                    tableEmployes.repaint();
                    messageLabel.setText("L'employé a mis a jour avec succès");
                    nomField.setText("");
                    prenomField.setText("");
                    departementField.setText("");
                    salaireField.setText("");
                }
            }
        });

        //supprimer button
        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText("");
                int selectedrow = tableEmployes.getSelectedRow();
                if (selectedrow == -1){
                    if (modelim.getRowCount() == 0){
                        messageLabel.setText("Le tableau est déjà vide");
                    }
                    else {
                        messageLabel.setText("Veuillez sélectionner l'employé que vous souhaitez supprimer");
                    }
                }
                else{
                    String string = modelim.getValueAt(selectedrow,0).toString();
                    int id = Integer.parseInt(string);
                    actions.supprimer(id);

                    modelim.getDataVector().removeAllElements();
                    modelim.fireTableDataChanged();
                    ajouteTable();
                    messageLabel.setText("L'employé a été supprimé avec succès");
                    nomField.setText("");
                    prenomField.setText("");
                    departementField.setText("");
                    salaireField.setText("");
                }
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


        tableEmployes.setModel(modelim);

    }


}


