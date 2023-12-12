package birb;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Birb {
    private final int startingPosition = 168;
    private int Position = 336;
    private int velocity = 5;
    private boolean running;
    public Image BirbImage1;
    public Image BirbImage2;
    public Image BirbImage3;
    public Image BirbImage4;
    public Image BirbImage5;
    public Birb(){
        try {
            BirbImage1 = ImageIO.read(new File("src/assets/birb1.png"));
            BirbImage2 = ImageIO.read(new File("src/assets/birb2.png"));
            BirbImage3 = ImageIO.read(new File("src/assets/birb3.png"));
            BirbImage4 = ImageIO.read(new File("src/assets/birb4.png"));
            BirbImage5 = ImageIO.read(new File("src/assets/birb5.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void jump(){
        velocity = -18;
    }

    public void run(){
        Position += velocity;
        velocity += 3;
    }
    public void start(){
        running = true;
    }
    public void stop(){
        running = false;
    }

    public boolean isRunning(){
        return running;
    }

    public int getX(){
        return startingPosition;
    }

    public int getY(){
        return Position;
    }

    public void hitGround(int ground){
        Position = ground;
    }
}
