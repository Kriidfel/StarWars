import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import master.Jedi;
import master.Sith;

public class Main {
    // Scanner object to read user input
    private static final Scanner scanner = new Scanner(System.in);
    // List to store Jedi characters
    static List<Jedi> jediList = new ArrayList<>();
    // List to store Sith characters
    static List<Sith> sithList = new ArrayList<>();

    /**
     * Main method to start the application.
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        mainMenu();
    }

    /**
     * Displays the main menu and handles character creation and combat.
     */
    private static void mainMenu() {
        boolean mainRun = true;
        boolean createRun = true;

        // Loop to handle character creation
        while (createRun) {
            System.out.print("Combien de personnages voulez-vous créer ? /!\\ nb pair /!\\ ");
            int nb = scanner.nextInt();
            if (nb % 2 != 0) {
                mainMenu();
            }

            // Loop to create the specified number of characters
            for (int i = 0; i < nb; i++) {
                System.out.println("1. Jedi");
                System.out.println("2. Sith");
                int choice = scanner.nextInt();

                System.out.print("Nom du personnage : ");
                String name = scanner.next();
                System.out.print("Max HP : ");
                int maxHp = scanner.nextInt();
                System.out.print("Damage : ");
                int damage = scanner.nextInt();

                // Switch case to handle Jedi and Sith creation
                switch (choice) {
                    case 1:
                        System.out.print("Force : ");
                        int force = scanner.nextInt();
                        Jedi jedi = new Jedi(name, maxHp, maxHp, damage, force);
                        jediList.add(jedi);
                        createRun = false;
                        break;
                    case 2:
                        Sith sith = new Sith(name, maxHp, maxHp, damage);
                        sithList.add(sith);
                        createRun = false;
                        break;
                }
            }
        }

        // Loop to handle combat between characters
        while (mainRun) {
            // Randomly select a Jedi and a Sith for combat
            Jedi jedi = jediList.get((int) (Math.random() * jediList.size()));
            Sith sith = sithList.get((int) (Math.random() * sithList.size()));

            // Display character information
            System.out.println(jedi);
            System.out.println(sith);

            // Randomly decide which character attacks first
            if (Math.random() < 0.5) {
                jedi.attack(sith);
                if (sith.isAlive()) {
                    sith.attack(jedi);
                    if (!jedi.isAlive()) {
                        System.out.println(sith + " a gagné !");
                        mainRun = false;
                    }
                } else {
                    System.out.println(jedi + " a gagné !");
                    mainRun = false;
                }
            } else {
                sith.attack(jedi);
                if (jedi.isAlive()) {
                    jedi.attack(sith);
                    if (!sith.isAlive()) {
                        System.out.println(jedi + " a gagné !");
                        mainRun = false;
                    }
                } else {
                    System.out.println(sith + " a gagné !");
                    mainRun = false;
                }
                jedi.attack(sith);
                if (!sith.isAlive()) {
                    System.out.println(jedi + " a gagné !");
                    mainRun = false;
                }
            }
        }
    }
}