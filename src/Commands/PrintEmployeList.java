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

        for (int i = 0; i < employes.size(); i++) {
            System.out.printf("%d. %s\n", i+1, employes.get(i).getName());
        }
    }
}
