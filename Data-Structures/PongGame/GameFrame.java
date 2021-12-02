import java.awt.*;
import javax.swing.*;

/**
 creates a new game panel and adds the background and prints toString in log
 */
class GameFrame extends JFrame {
    private boolean isCom = false;
    private boolean isGravity = false;
    private boolean isSimulation = false;
    private String instructions = "Started the game!\nPlayer 1: W, A, S, D Keys.\nPlayer 2: Arrow Keys.";

    public GameFrame() {
        String[] options = {"2 Players", "Play vs Computer", "2 Player Gravity", "Computer Gravity", "Simulation"};

        String gameMenu = (String) JOptionPane.showInputDialog(
                null,
                "Select The Gamemode",
                "Choose Gamemode",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        switch (gameMenu) {
            case "Play vs Computer" -> {
                isCom = true;
                instructions = "Started the game!\nUse the W, A, S, D Keys.";
            }
            case "2 Player Gravity" -> isGravity = true;
            case "Computer Gravity" -> {
                isCom = true;
                isGravity = true;
                instructions = "Started the game!\nUse the W, A, S, D Keys.";
            }
            case "Simulation" -> {
                isSimulation = true;
                instructions = "Started the game!\nWatch the game play!";
            }
        }

        JOptionPane.showMessageDialog(null, instructions, "Game Started!", JOptionPane.INFORMATION_MESSAGE);

        GamePanel panel = new GamePanel(isCom, isGravity, isSimulation);
        this.add(panel);
        this.setTitle("The Best Pong Game");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    /**
     * @return String game info
     */
    public String toString() {
        return "Computer: " + isCom + "\nGravity: " + isGravity + "\nSimulation: " + isSimulation + "\nInstructions:\n" + instructions;
    }
}
