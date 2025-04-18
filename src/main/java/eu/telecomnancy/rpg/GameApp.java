package eu.telecomnancy.rpg;

import eu.telecomnancy.rpg.facade.GameFacade;
import eu.telecomnancy.rpg.patterns.prototype.Team;
import eu.telecomnancy.rpg.patterns.prototype.Warrior;
import eu.telecomnancy.rpg.patterns.prototype.Wizard;
import eu.telecomnancy.rpg.patterns.command.*;
import java.util.Scanner;

public class GameApp {
    public static void main(String[] args) {
        GameFacade facade = new GameFacade();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenu au jeu de RPG !");
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu Principal :");
            System.out.println("1. Creer une equipe");
            System.out.println("2. Ajouter un personnage a une equipe");
            System.out.println("3. Executer une Commande (Heal, Buff, Attack)");
            System.out.println("4. Voir les equipes et personnages");
            System.out.println("5. Quitter");
            System.out.print("Entrer votre choix : ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Entrez un nom pour l'equipe : ");
                    String teamName = scanner.nextLine();
                    facade.addTeam(new Team(teamName));
                    System.out.println("Equipe " + teamName + " creee.");
                    break;

                case 2:
                    System.out.print("Entrez un nom pour l'equipe : ");
                    teamName = scanner.nextLine();
                    Team team = facade.getTeam(teamName);
                    if (team != null) {
                        System.out.print("Entrez le type de personnage (Warrior/Wizard) : ");
                        String type = scanner.nextLine();
                        System.out.print("Entrez le nom du personnage : ");
                        String charName = scanner.nextLine();
                        if (type.equalsIgnoreCase("Warrior")) {
                            team.addPlayer(new Warrior(charName));
                            System.out.println("Warrior " + charName + " ajoute a " + teamName + ".");
                        } else if (type.equalsIgnoreCase("Wizard")) {
                            team.addPlayer(new Wizard(charName));
                            System.out.println("Wizard " + charName + " ajoute a " + teamName + ".");
                        } else {
                            System.out.println("Type de personnage invalid.");
                        }
                    } else {
                        System.out.println("Equipe pas trouvee.");
                    }
                    break;

                case 3:
                    System.out.print("Entrez une commande (Heal/Buff/Attack): ");
                    String command = scanner.nextLine();
                    if (command.equalsIgnoreCase("Heal")) {
                        System.out.print("Entrez le nom de lequipe a guerir: ");
                        teamName = scanner.nextLine();
                        team = facade.getTeam(teamName);
                        if (team != null) {
                            new HealCommand(team).execute();
                        } else {
                            System.out.println("Equipe pas trouvee.");
                        }
                    } else if (command.equalsIgnoreCase("Buff")) {
                        System.out.print("Entrez le nom d'equipe a ameliorer : ");
                        teamName = scanner.nextLine();
                        team = facade.getTeam(teamName);
                        if (team != null) {
                            new BuffCommand(team).execute();
                        } else {
                            System.out.println("Equipe pas trouvee.");
                        }
                    } else if (command.equalsIgnoreCase("Attaque")) {
                        System.out.print("Entrez l'equipe d'attaque: ");
                        String attacker = scanner.nextLine();
                        System.out.print("Entrez l'equipe de defense: ");
                        String defender = scanner.nextLine();
                        Team attackerTeam = facade.getTeam(attacker);
                        Team defenderTeam = facade.getTeam(defender);
                        if (attackerTeam != null && defenderTeam != null) {
                            new AttackCommand(attackerTeam, defenderTeam).execute();
                        } else {
                            System.out.println("Une ou toutes les equipes n'ont pas ete trouvees.");
                        }
                    } else {
                        System.out.println("Commande invalide.");
                    }
                    break;

                case 4:
                    System.out.println("Equipes et personnages:");
                    for (Team t : facade.getAllTeams()) {
                        System.out.println("- " + t.getName());
                        for (var player : t.getPlayers()) {
                            System.out.println("  - " + player.getName() + " (" + player.getClass().getSimpleName() + ")");
                        }
                    }
                    break;

                case 5:
                    exit = true;
                    System.out.println("Quitter le jeu. Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalid. Ressayez");
            }
        }

        scanner.close();
    }
}
