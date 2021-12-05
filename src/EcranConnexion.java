import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EcranConnexion extends JFrame{
    private JPanel panel1;
    private JButton connexionButton;
    private JPasswordField passwordChamp;
    private JTextField utilisateurChamp;
    private JLabel messageChamp;

    public EcranConnexion() {
        connexionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionEmployes actionEmployes = new ActionEmployes();
                messageChamp.setText("");

                String utilisateur = utilisateurChamp.getText();
                String password = new String(passwordChamp.getPassword());


                boolean connexionReussi = actionEmployes.connexion(utilisateur, password);

                if (connexionReussi){
                    EcranEmployes ecranEmployes = new EcranEmployes();
                    setVisible(false);
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

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Écran de connexion");
        jFrame.setSize(80, 300);
        jFrame.setContentPane(new EcranConnexion().panel1);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
    }
}
