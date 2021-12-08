import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EcranConnexion extends JFrame{
    JFrame frame = new JFrame("Connexion");
    JPanel panel1 = new JPanel();
    JLabel label1 = new JLabel("Utilisateur : ");
    JLabel label2 = new JLabel("Mot de Passe : ");
    JTextField utilisateurChamp = new JTextField();
    JPasswordField passwordChamp = new JPasswordField();
    JLabel messageChamp = new JLabel();
    JCheckBox checkBox = new JCheckBox("Afficher mot de passe");
    JButton connexionButton = new JButton("Connection");

    public EcranConnexion() {
        frame.setSize(500, 300);
        frame.setLayout(null);
        panel1.setLayout(null);
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        //label Utilisateur
        panel1.add(label1);
        label1.setBounds(50, 45, 100, 25);
        label1.setSize(100,25);

        //texField Utilisateur
        panel1.add(utilisateurChamp);
        utilisateurChamp.setBounds(150, 45, 295, 25);
        utilisateurChamp.setSize(295,25);

        //label mot de passe
        panel1.add(label2);
        label2.setBounds(50, 80, 100, 25);
        label2.setSize(100,25);

        //password field
        panel1.add(passwordChamp);
        passwordChamp.setBounds(150, 80, 295, 25);
        passwordChamp.setSize(295,25);

        //checkbox
        panel1.add(checkBox);
        checkBox.setBounds(50, 115, 180, 25);
        checkBox.setSize(180,25);

        //label mot de passe
        panel1.add(messageChamp);
        messageChamp.setBounds(50, 150, 400, 25);
        messageChamp.setSize(400,25);
        messageChamp.setForeground(Color.RED);
        messageChamp.setText("");

        //connection button
        panel1.add(connexionButton);
        connexionButton.setBounds(125, 185, 250, 25);
        connexionButton.setSize(250,25);

        //checkbox utilisation
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox.isSelected()){
                    passwordChamp.setEchoChar((char) 0);
                }
                else {
                    passwordChamp.setEchoChar('*');
                }
            }
        });

        connexionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionEmployes actionEmployes = new ActionEmployes();
                messageChamp.setText("");

                String utilisateur = utilisateurChamp.getText();
                String password = new String(passwordChamp.getPassword());


                boolean connexionReussi = actionEmployes.connexion(utilisateur, password);

                if (connexionReussi){
                    setVisible(false);
                    EcranEmployes ecranEmployes = new EcranEmployes();

                    ecranEmployes.setVisible(true);
                    //System.exit(0);
                }
                else messageChamp.setText("Échec de la connexion... Veuillez réessayer");
            }
        });
        connexionButton.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                EcranConnexion ecranConnexion = new EcranConnexion();
                int touch = e.getKeyCode();
                if (touch == KeyEvent.VK_ENTER){
                    ecranConnexion.connexionButton.doClick();
                }


            }
        });
    }


}
