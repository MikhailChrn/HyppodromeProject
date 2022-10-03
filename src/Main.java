import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// 03.oct.2022
// Hippodrome
// release 1.0

public class Main extends JFrame {
    protected JTextArea mainField = new JTextArea();
    protected JPanel bottomPanel = new JPanel();
    protected JLabel numberOfHorsesLebel = new JLabel("Кол.во лошадей в заезде :");
    protected JTextField numberOfHorsesField = new JTextField(3);
    protected JButton buttonStart = new JButton("Старт !");
    protected int numberOfHorses;

    protected Main() {
        this.setTitle("Hippodrome");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(mainField, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.PAGE_END);
        bottomPanel.setBackground(Color.LIGHT_GRAY);
        bottomPanel.add(numberOfHorsesLebel);
        bottomPanel.add(numberOfHorsesField);
        bottomPanel.add(buttonStart);

        MouseAdapter myMouseList = new MyListener();
        buttonStart.addMouseListener(myMouseList);

        setSize(750, 300);
        setVisible(true);
    } // end MainWindow constructor

    protected void startGame(int numberOfHorse) {
        Hippodrome game = new Hippodrome(mainField, numberOfHorse);
        try {
            game.start();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    } // end void startGame

    protected class MyListener extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            numberOfHorses = Integer.valueOf(numberOfHorsesField.getText());
            new Thread(() -> startGame(numberOfHorses)).start();
        }
    } // end MyListener

    public static void main(String[] args) {
        new Main();
    } // end void main
}