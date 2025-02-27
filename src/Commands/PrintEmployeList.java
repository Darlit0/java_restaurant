package Commands;
import DataBases.DbEmploye;
import Models.Employe;

import java.util.ArrayList;

public class PrintEmployeList extends Command {
    public DbEmploye dbEmploye;

    public PrintEmployeList(DbEmploye dbEmploye) {
        this.dbEmploye = dbEmploye;
    }

    @Override
    public String getLabel() {
        return "Lister les employés";
    }

    @Override
    public void execute() {
        ArrayList<Employe> employes = dbEmploye.getEmployes();

        if (employes.isEmpty()) {
            System.out.println("Aucun employé trouvé.");
        } else {
            System.out.println("Liste des employés :");
            for (int i = 0; i < employes.size(); i++) {
                Employe employe = employes.get(i);
                System.out.printf("%d. %s %s, Role: %s, Salaire: %d, Date d'embauche: %s\n",
                        i + 1, employe.getFirstname(), employe.getName(),
                        employe.getRole(), employe.getSalaire(), employe.getDateEmbauche());
            }
        }
    }
}