package DataBases;

import Models.Employe;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class DbEmploye extends DataBase<Employe> {
    public ArrayList<Employe> employes;

    public DbEmploye() {
        this.employes = this.loadAll();
    }

    public ArrayList<Employe> getEmployes() {
        return employes;
    }

    @Override
    public Employe load(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int id = Integer.parseInt(reader.readLine());
            String name = reader.readLine();
            String firstname = reader.readLine();
            String role = reader.readLine();
            int salaire = Integer.parseInt(reader.readLine());
            String dateEmbauche = reader.readLine();

            reader.close();

            return new Employe(id, name, firstname, role, salaire, dateEmbauche);
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier " + file.getName());
            return null;
        }
    }

    @Override
    public ArrayList<Employe> loadAll() {
        ArrayList<Employe> employes = new ArrayList<Employe>();
        File folder = new File("./employes/");

        // Vérifiez si le répertoire existe et est un répertoire
        if (folder.exists() && folder.isDirectory()) {
            File[] listOfFiles = folder.listFiles();

            // Vérifiez si listOfFiles n'est pas null
            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.isFile() && file.getName().startsWith("employe_")) {
                        Employe employe = this.load(file);
                        if (employe != null) {
                            employes.add(employe);
                        }
                    }
                }
            } else {
                System.out.println("Aucun fichier trouvé dans le répertoire.");
            }
        } else {
            System.out.println("Le répertoire ./employes/ n'existe pas ou n'est pas un répertoire.");
        }

        return employes;
    }

    @Override
    public void delete(int id) {
        String filename = String.format("./employes/employe_%d.txt", id);
        File file = new File(filename);

        if (file.delete()) {
            Iterator<Employe> iterator = employes.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().getId() == id) {
                    iterator.remove();
                    break;
                }
            }
            System.out.println("L'employé' a été supprimé avec succès.");
        } else {
            System.out.println("Échec de la suppression de l'employé.");
        }
    }

    @Override
    public Employe get(int id) {
        for (Employe employe : employes) {
            if (employe.getId() == id) {
                return employe;
            }
        }
        return null;
    }

    @Override
    public void create(Employe employe) {
        String filename = String.format("./employes/employe_%d.txt", employe.getId());
        File f = new File(filename);

        System.out.println("Sauvegarde de l'employé dans " + filename);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));

            writer.append(Integer.toString(employe.getId()));
            writer.append("\n");
            writer.append(employe.getName());
            writer.append("\n");
            writer.append(employe.getFirstname());
            writer.append("\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde de l'employé");
        }
    }
}
