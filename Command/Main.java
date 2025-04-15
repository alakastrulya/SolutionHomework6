package Command;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Light livingRoomLight = new Light();
        Thermostat thermostat = new Thermostat();
        Curtains curtains = new Curtains();


        Command turnOnLight = new TurnOnLightCommand(livingRoomLight);
        Command turnOffLight = new TurnOffLightCommand(livingRoomLight);
        Command setThermostat = new SetThermostatCommand(thermostat, 22);
        Command closeCurtains = new CloseCurtainsCommand(curtains);
        Command openCurtains = new OpenCurtainsCommand(curtains);
        Command goodnightMode = new MiniCommand(Arrays.asList(
                turnOffLight,
                new SetThermostatCommand(thermostat, 18),
                closeCurtains
        ));
        Command goodMorningMode = new MiniCommand(Arrays.asList(
                turnOnLight,
                new SetThermostatCommand(thermostat, 24),
                openCurtains
        ));


        SmartHomeRemoteControl remote = new SmartHomeRemoteControl();

        remote.setCommand(1, turnOnLight);
        remote.setCommand(2, turnOffLight);
        remote.setCommand(3, setThermostat);
        remote.setCommand(4, goodnightMode);
        remote.setCommand(5, goodMorningMode);

        // CLI-menu
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("=== Status ===");
            System.out.println("Light: " + livingRoomLight.getStatus());
            System.out.println("Thermostat: " + thermostat.getStatus());
            System.out.println("Curtains: " + curtains.getStatus());

            System.out.println("Smart Home Remote Control");
            System.out.println("1. Turn on light (Slot 1)");
            System.out.println("2. Turn off light (Slot 2)");
            System.out.println("3. Set thermostat to 22°C (Slot 3)");
            System.out.println("4. Goodnight mode (Slot 4)");
            System.out.println("5. GoodMorning mode (Slot 5)");
            System.out.println("6. Undo last command");
            System.out.println("7. Redo last undone command");
            System.out.println("8. Exit");
            System.out.print("Choose option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please write a number");
                continue;
            }

            switch (choice) {
                case 1:
                    remote.pressButton(1);
                    break;
                case 2:
                    remote.pressButton(2);
                    break;
                case 3:
                    remote.pressButton(3);
                    break;
                case 4:
                    remote.pressButton(4);
                    break;
                case 5:
                    remote.pressButton(5);
                    break;
                case 6:
                    remote.undoButton();
                    break;
                case 7:
                    remote.redoButton();
                    break;
                case 8:
                    System.out.println("exit...");
                    scanner.close();
                    return;
                default:
                    System.out.println("we dont have this option!");
            }
        }
    }
}