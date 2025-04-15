package Command;

public class Thermostat {
    private int currentTemperature;
    private int previousTemperature;

    public Thermostat() {
        this.currentTemperature = 10;
        this.previousTemperature = 5;
    }

    public void setTemperature(int temperature) {
        this.previousTemperature = this.currentTemperature;
        this.currentTemperature = temperature;
        System.out.println("[Thermostat] Setting temperature to " + temperature + "°C");
    }

    public void revertToPrevious() {
        this.currentTemperature = this.previousTemperature;
        System.out.println("[Thermostat] Reverting to previous temperature");
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }

    public String getStatus() {
        return "Current temperature: " + currentTemperature + "°C";
    }
}