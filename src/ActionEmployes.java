
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author candas
 */
public class ActionEmployes {
    private static Connection con = null;
    
    private static Statement statement = null;
    private PreparedStatement preparedStatement = null;



    static ResultSet yap(){
        try {
            statement = con.createStatement();
            String interrogation = "Select * From calisanlar";
            ResultSet rs;

            rs = statement.executeQuery(interrogation);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void supprimer(int id){
        String interrogation = "Delete from calisanlar where id = ?";
        try {
            preparedStatement = con.prepareStatement(interrogation);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void metJourEmployes (int id, String nouvelNom, String nouvelPrenom, String nouvelDpartement, String nouvelSalaire){
        String interrogation = "Update calisanlar set soyad = ?, ad = ?, departman = ?, maas = ? where id = ?";

        try {
            preparedStatement = con.prepareStatement(interrogation);
            preparedStatement.setString(1,nouvelNom);
            preparedStatement.setString(2,nouvelPrenom);
            preparedStatement.setString(3,nouvelDpartement);
            preparedStatement.setString(4,nouvelSalaire);

            preparedStatement.setInt(5,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void ajoutePersonne(String nom, String prenom, String departement, String salaire){
        String interrogation = "Insert into calisanlar (soyad,ad,departman,maas) VALUES(?,?,?,?)";

        try {
            preparedStatement = con.prepareStatement(interrogation);
            preparedStatement.setString(1,nom);
            preparedStatement.setString(2,prenom);
            preparedStatement.setString(3,departement);
            preparedStatement.setString(4,salaire);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean connexion(String utilisateur, String password){
        String sorgu = "Select * From adminler where username = ? and password = ?";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, utilisateur);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();


            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ActionEmployes(){
        String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.nom_db;

        try {            
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Pilote introuvable...");
        }
        try{
            con = DriverManager.getConnection(url, Database.utilisateur, Database.password);
            System.out.println("Connexion réussie...");
        }catch (Exception ex) {
             System.out.println("La connexion a échoué");
        }
    }


}
