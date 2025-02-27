import Commands.Command;
import DataBases.DbEmploye;
import DataBases.DbRestaurant;
import Models.Restaurant;
import Models.Employe;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public ArrayList<Restaurant> restaurants;

    public static void main(String[] args) {
        DbRestaurant dbRestaurant = new DbRestaurant();
        dbRestaurant.loadAll();
        DbEmploye dbEmploye = new DbEmploye();
        dbEmploye.loadAll();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu :");

            Command[] commands = {
                    new Commands.AddRestaurant(dbRestaurant, scanner),
                    new Commands.DeleteRestaurant(dbRestaurant, scanner),
                    new Commands.DeleteEmploye(dbEmploye, scanner),
                    new Commands.PrintRestaurantList(dbRestaurant),
                    new Commands.PrintEmployeList(dbEmploye),
                    new Commands.AddEmploye(dbEmploye, scanner),
                    new Commands.Quit()
            };

            for (int i = 0; i < commands.length; i++) {
                System.out.println((i + 1) + ". " + commands[i].getLabel());
            }

            int option = chooseOption(scanner);

            if (option < 0 || option >= commands.length) {
                System.out.println("Option inconnue");
                continue;
            }

            commands[option].execute();
        }
    }

    private static int chooseOption(Scanner scanner) {
        try {
            if (scanner.hasNextInt()) {
                return scanner.nextInt() - 1;
            } else {
                scanner.next();
                return -1;
            }
        } catch (Exception e) {
            return -1;
        }
    }
}
