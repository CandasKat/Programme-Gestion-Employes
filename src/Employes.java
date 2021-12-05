public class Employes {
    private int id;
    private String prenom;
    private  String nom;
    private String departement;
    private String salaire;


    public Employes(int id, String prenom, String nom, String departement, String salaire) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.departement = departement;
        this.salaire = salaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getSalaire() {
        return salaire;
    }

    public void setSalaire(String salaire) {
        this.salaire = salaire;
    }
}
