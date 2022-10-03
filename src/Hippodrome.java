import javax.swing.JTextArea;
import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public JTextArea textOut;
    protected List<Horse> horses;
    protected int numberOfHorses;
    protected int avgSpeed;
    protected Hippodrome(JTextArea out, int numberOfHorses) {
        this.textOut = out;
        this.numberOfHorses = numberOfHorses;
        // create horses HERE !!!
        horses = new ArrayList<>();
        for (int i = 1; i <= numberOfHorses; i++)
            this.getHorses().add(new Horse("horse" + i, 3, 0, textOut));
        textOut.append("Horses was created !");
    } // end constructor

    protected List getHorses() {
        return horses;
    }

    protected void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    protected void move() {
        for(Horse horse : horses) horse.move();
    }

    protected void print() {
        textOut.setText(null);
        for(Horse horse : horses) horse.print();
    }

    protected Horse getWinner() {
        Horse winner = null;
        double max = 0;
        for (Horse horse : horses) if (horse.getDistance() > max) max = horse.getDistance();
        for (Horse horse : horses) if (horse.getDistance() == max) winner = horse;
        return winner;
    }

    protected void printWinner() {
        textOut.append("Winner is " + getWinner().getName() + "!"  + "\n");
    }

    protected void start() throws InterruptedException {
        this.run();
        this.printWinner();
    }
}