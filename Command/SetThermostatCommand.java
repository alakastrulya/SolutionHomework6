package Command;

public class SetThermostatCommand implements Command {
    private Thermostat thermostat;
    private int temperature;
    private int previousTemperature;

    public SetThermostatCommand(Thermostat thermostat, int temperature) {
        this.thermostat = thermostat;
        this.temperature = temperature;
    }

    public void execute() {
        this.previousTemperature = thermostat.getCurrentTemperature();
        thermostat.setTemperature(temperature);
    }

    public void undo() {
        thermostat.revertToPrevious();
    }
}