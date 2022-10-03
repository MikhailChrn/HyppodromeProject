import javax.swing.JTextArea;
import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public JTextArea textOut;
    protected List<Horse> horses;
    protected int numberOfHorses;

    protected Hippodrome(JTextArea textOut, int numberOfHorses) {
        this.textOut = textOut;
        this.numberOfHorses = numberOfHorses;
        // create horses HERE !!!
        horses = new ArrayList<>();
        for (int i = 1; i <= numberOfHorses; i++)
            this.getHorses().add(new Horse("horse" + i, 3, 0, textOut));
        textOut.append("Horses was created !");
    } // end Hippodrome.constructor

    protected List getHorses() {
        return horses;
    } // end List Hippodrome.getHorses

    protected void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            this.move();
            this.print();
            Thread.sleep(200);
        }
    } // end void Hippodrome.run

    protected void move() {
        for(Horse horse : horses) horse.move();
    } // end void Hippodrome.move

    protected void print() {
        textOut.setText(null);
        for(Horse horse : horses) horse.print();
    } // end void Hippodrome.print

    protected Horse getWinner() {
        Horse winner = null;
        double max = 0;
        for (Horse horse : horses) if (horse.getDistance() > max) max = horse.getDistance();
        for (Horse horse : horses) if (horse.getDistance() == max) winner = horse;
        return winner;
    } // end void getWinner

    protected void printWinner() {
        textOut.append("Winner is " + getWinner().getName() + "!"  + "\n");
    } // end void printWinner

    protected void start() throws InterruptedException {
        this.run();
        this.printWinner();
    }
}