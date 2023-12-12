package menu;

import javax.swing.*;
import java.awt.*;

public class StartMenu extends JLabel {

    public StartMenu() {
        setBounds(50, 600, 100, 30);
        setFont(new Font("Verdana", Font.PLAIN, 18));
        setText("Press any key to start");
    }
}
