package Commands;

import DataBases.DbEmploye;
import Models.Employe;
import java.util.Scanner;

public class AddEmploye extends Command {
    public DbEmploye dbEmploye;
    private Scanner scanner;

    public AddEmploye(DbEmploye dbEmploye, Scanner scanner) {
        this.scanner = scanner;
        this.dbEmploye = dbEmploye;
    }

    @Override
    public String getLabel() {
        return "Ajouter un employé";
    }

    @Override
    public void execute() {
        System.out.println("Ajout d'un employe");
        System.out.println("Identifiant : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nom : ");
        String name = scanner.nextLine();
        System.out.println("Prénom : ");
        String firstname = scanner.nextLine();
        System.out.println("Role : ");
        String role = scanner.nextLine();
        System.out.println("Salaire : ");
        int salaire = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Date d'embauche : ");
        String dateEmbauche = scanner.nextLine();

        dbEmploye.create(new Employe(id, name, firstname, role, salaire, dateEmbauche));
    }

}
