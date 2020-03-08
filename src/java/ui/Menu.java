package ui;

import client.ConsoleClient;
import client.GameClient;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import utilities.InputAssistance;

public class Menu {

    ConsoleClient consoleClient = new ConsoleClient();
    GameClient gameClient = new GameClient();
    GameManagment gameManagment = new GameManagment();
    ConsoleManagment consoleManagment = new ConsoleManagment();

    public void mainMenu() {
        boolean loop = true;
        while (loop) {
            System.out.println("");
            System.out.println("Main menu");
            System.out.println("1. Manage games");
            System.out.println("2. Manage consoles");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = InputAssistance.intInput();
            switch (choice) {
                case 1:
                    gameMenu();
                    break;
                case 2:
                    consoleMenu();
                    break;
                case 0:
                    loop = false;
                    break;
            }
        }
    }

    private void gameMenu() {
        boolean loop = true;
        while (loop) {
            System.out.println("");
            System.out.println("1. Create game");
            System.out.println("2. Delete game");
            System.out.println("3. Update game");
            System.out.println("4 Get single game");
            System.out.println("5. Get all games");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = InputAssistance.intInput();
            switch (choice) {
                case 1:
                    try {
                        gameManagment.createGame();
                    } catch (BadRequestException e) {
                    }
                    
                    break;
                case 2:
                    try {
                        gameManagment.deleteGame();
                    } catch (NotFoundException e) {
                        System.out.println("Invald game id, game does not exist.");
                    }

                    break;
                case 3:
                    try {
                        gameManagment.updateGame();
                    } catch (NotFoundException e) {
                        System.out.println("Invald game id, game does not exist.");
                    }
                    break;
                case 4:
                    try {
                        gameManagment.getGame();
                    } catch (NotFoundException e) {
                        System.out.println("Invalid id, game does not exist.");
                    }

                    break;
                case 5:
                    try {
                        gameManagment.getAllGames();
                    } catch (NotFoundException e) {
                        System.out.println("No games present in database.");
                    }

                    break;
                case 0:
                    loop = false;
                    break;
            }
        }

    }

    private void consoleMenu() {
        boolean loop = true;
        while (loop) {
            System.out.println("");
            System.out.println("1. Create console");
            System.out.println("2. Delete console");
            System.out.println("3. Update console");
            System.out.println("4 Get single console");
            System.out.println("5. Get all consoles");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = InputAssistance.intInput();
            switch (choice) {
                case 1:
                    consoleManagment.createConsole();
                    break;
                case 2:
                    try {
                        consoleManagment.deleteConsole();
                    } catch (NotFoundException e) {
                        System.out.println("Invalid console name, console does not exist.");
                    }
                    break;
                case 3:
                    try {
                        consoleManagment.updateConsole();
                    } catch (NotFoundException e) {
                        System.out.println("Invalid console name, console does not exist.");
                    }
                    break;
                case 4:
                    try {
                        consoleManagment.findConsoleByName();
                    } catch (NotFoundException e) {
                        System.out.println("Invalid console name, console does not exist.");
                    }
                    break;
                case 5:
                    try {
                        consoleManagment.getAllConsoles();
                    } catch (NotFoundException e) {
                        System.out.println("No consoles present in database.");
                    }

                    break;
                case 0:
                    loop = false;
                    break;
            }
        }

    }

}
