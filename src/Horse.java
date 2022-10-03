import javax.swing.JTextArea;

public class Horse {
    private String name;
    private double speed;
    private double distance;
    protected JTextArea textArea;

    public Horse(String name, double speed, double distance, JTextArea textArea) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
        this.textArea = textArea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    } // end double Horse.getDistance

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void move() {
        distance += speed * Math.random();
    } // end void Horse.move

    public void print() {
        for (int i = 0; i < (int)distance; i++) textArea.append(".");
        textArea.append(this.name + "\n");
    } // end void Horse.print
}