package pipe;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Pipe {
    public int height;
    public int pipePosition = 704;
    public final int pipeWidth = 50;
    public int pipeSpeed = -5;
    private Random random;
    public Image pipImage;
    public Pipe(){
        random = new Random();
        height = random.nextInt(150,450);
        try {
            pipImage = ImageIO.read(new File("src/assets/pip.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pipeMove(){
        this.pipePosition += pipeSpeed;
    }

}
