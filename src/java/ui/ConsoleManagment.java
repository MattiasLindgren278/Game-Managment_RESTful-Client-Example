package ui;

import client.ConsoleClient;
import java.util.List;
import model.Console;
import utilities.InputAssistance;

public class ConsoleManagment {

    InputAssistance inputAssistance = new InputAssistance();

    public Console createConsole() {
        System.out.print("Enter console name: ");
        String name = inputAssistance.stringInput();
        System.out.print("Enter name of console CPU: ");
        String cpuName = inputAssistance.stringInput();
        System.out.print("Enter CPU's clock rate: ");
        int cpuSpeed = inputAssistance.intInput();
        System.out.print("Enter console graphics card model: ");
        String graphicsCard = inputAssistance.stringInput();
        System.out.print("Enter consoles storage space: ");
        int storageSpace = inputAssistance.intInput();
        Console newConsole = new Console(name, cpuName, cpuSpeed, graphicsCard, storageSpace);
        ConsoleClient.createConsole(newConsole);
        return newConsole;
    }

    public void updateConsole() {
        Console console = findConsoleByName();
        System.out.print("Enter new name: ");
        String newName = inputAssistance.stringInput();
        console.setName(newName);
        ConsoleClient.updateConsole(console);
    }

    public void deleteConsole() {
        System.out.print("Enter id: ");
        String id = inputAssistance.stringInput();
        ConsoleClient.deleteConsole(id);

    }

    public Console findConsoleByName() {
        System.out.print("Enter console id: ");
        String id = inputAssistance.stringInput();
        Console console = ConsoleClient.findConsoleByName(id);
        System.out.println(console);
        return console;
    }

    public void getAllConsoles() {
        List<Console> consoles = ConsoleClient.getAllConsoles();
        for (Console console : consoles) {
            System.out.println(console);
        }

    }
}
