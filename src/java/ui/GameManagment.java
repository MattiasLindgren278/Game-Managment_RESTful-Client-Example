package ui;

import client.GameClient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Console;
import model.Game;
import utilities.InputAssistance;

public class GameManagment {

    InputAssistance inputAssistance = new InputAssistance();
    ConsoleManagment consoleManagment = new ConsoleManagment();

    public Game createGame() {
        System.out.print("Enter game title: ");
        String title = inputAssistance.stringInput();
        System.out.print("Enter game genre: ");
        String genre = inputAssistance.stringInput();
        System.out.print("Enter game release date: ");
        LocalDate releseDate = inputAssistance.localDateInput(inputAssistance.stringInput());

        System.out.print("Enter game storage space: ");
        int storageSpace = inputAssistance.intInput();
        List<Console> consoles = consoleListCreator();
        Game newGame = new Game(title, genre, consoles, releseDate, storageSpace);
        GameClient.createGame(newGame);
        return newGame;
    }

    public List<Console> consoleListCreator() {
        List<Console> consoleList = new ArrayList<>();
        boolean loop = true;
        while (loop) {
            System.out.println("1. Add console");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = inputAssistance.intInput();
            switch (choice) {
                case 1:
                    consoleList.add(consoleManagment.createConsole());
                    break;
                case 0:
                    loop = false;
                    break;
            }

        }
        return consoleList;
    }

    public void updateGame() {
        Game game = getGame();
        System.out.print("Enter new title: ");
        String title = inputAssistance.stringInput();
        game.setTitle(title);
        GameClient.updateGame(game);
    }

    public void deleteGame() {
        System.out.print("Enter game id: ");
        String id = inputAssistance.stringInput();
        GameClient.deleteGame(id);
    }

    public Game getGame() {
        System.out.print("Enter game id: ");
        String id = inputAssistance.stringInput();
        Game game = GameClient.findGameById(id);
        System.out.println(game);
        return game;
    }

    public void getAllGames() {
        List<Game> games = GameClient.getAllGames();
        for (Game game : games) {
            System.out.println(game);
        }

    }
}
