import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import master.Jedi;
import master.Sith;



public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    static List<Jedi> jediList = new ArrayList<>();
    static List<Sith> sithList = new ArrayList<>();



    public static void main(String[] args) {
        mainMenu();
    }

    private static void mainMenu(){
        boolean mainRun = true;
        boolean createRun = true;
        while (createRun){
            // Le joueur doit choisir le nombre de différents personnages qu'il souhaite créer /!\ nb pair /!\
            // ensuite les personnages sont créés et mis dans une liste différente pour les Jedi et les Sith
            System.out.println("Combien de personnages voulez-vous créer ? /!\\ nb pair /!\\ ");
            int nb = scanner.nextInt();
            if (nb % 2 != 0){
                mainMenu();
            }

            for (int i = 0; i <= nb; i++){
                System.out.println("Nom du personnage : ");
                String name = scanner.next();
                System.out.println("Max HP : ");
                int maxHp = scanner.nextInt();
                System.out.println("Def : ");
                int def = scanner.nextInt();
                System.out.println("Damage : ");
                int damage = scanner.nextInt();
                System.out.println("Force : ");
                int force = scanner.nextInt();
                System.out.println("1. Jedi");
                System.out.println("2. Sith");
                switch (scanner.nextInt()) {
                    case 1:
                        Jedi jedi = new Jedi(name, maxHp, maxHp, def, damage, force);
                        jediList.add(jedi);
                        createRun = false;
                        break;
                    case 2:
                        Sith sith = new Sith(name, maxHp, maxHp, def, damage);
                        sithList.add(sith);
                        createRun = false;
                        break;
                }
            }
        }


        while (mainRun){

            //le jeu choisit aléatoirement un Jedi et un Sith pour le combat
            Jedi jedi = jediList.get((int) (Math.random() * jediList.size()));
            Sith sith = sithList.get((int) (Math.random() * sithList.size()));

            //le jeu affiche les informations des personnages
            System.out.println(jedi);
            System.out.println(sith);

            //le jeu fait attaquer le Jedi et le Sith il prend alléatoirement le personnage pour attaquer en premier

            if (Math.random() < 0.5){
                jedi.attack(sith);
                if(sith.isAlive()){
                    sith.attack(jedi);
                    if (!jedi.isAlive()){
                        System.out.println(sith + " a gagné !");
                        mainRun = false;
                    }
                }
                else {
                    System.out.println(jedi + " a gagné !");
                    mainRun = false;
                }

            } else {
                sith.attack(jedi);
                if(jedi.isAlive()){
                    jedi.attack(sith);
                    if (!sith.isAlive()){
                        System.out.println(jedi + " a gagné !");
                        mainRun = false;
                    }
                }
                else {
                    System.out.println(sith + " a gagné !");
                    mainRun = false;
                }
                jedi.attack(sith);
                if(!sith.isAlive()){
                    System.out.println(jedi + " a gagné !");
                    mainRun = false;
                }
            }
        }
    }

}