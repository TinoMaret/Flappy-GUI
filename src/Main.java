import javax.swing.*;
import java.awt.*;
import panel.*;
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Flappy birb");
        frame.setIconImage(new ImageIcon("src/assets/birb.png").getImage());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(new GamePanel(), BorderLayout.CENTER);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}