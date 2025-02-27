package Models;

public class Employe {
    private int id;
    private String name;
    private String firstname;
    private String role;
    private int salaire;
    private String dateEmbauche;

    public Employe(int id, String name, String firstname, String role, int salaire, String dateEmbauche) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.role = role;
        this.salaire = salaire;
        this.dateEmbauche = dateEmbauche;
    }

    public int getId() {
        return id;
    }

    public String getName() { return name; }

    public String getFirstname() { return firstname; }

    public String getRole() { return role; }

    public int getSalaire() { return salaire; }

    public String getDateEmbauche() { return dateEmbauche; }
}
