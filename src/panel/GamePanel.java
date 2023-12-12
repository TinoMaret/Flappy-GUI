package panel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import birb.Birb;
import menu.*;
import pipe.Pipe;

public class GamePanel extends JPanel implements ActionListener {
    private final int SCREEN_WIDTH = 704;
    private final int SCREEN_HEIGHT = 704;
    private StartMenu menu = new StartMenu();
    private Image bgImage;
    private Birb birb = new Birb();
    private Timer timer;
    private Pipe[] pipes = {new Pipe(), new Pipe()};
    private int birbAnimation = 1;
    public GamePanel(){
        try {
            bgImage = ImageIO.read(new File("src/assets/bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        setOpaque(false);
        setFocusable(true);
        addMouseListener(new MyMouseListener());
        add(menu);
    }

    public void StartGame(){
        this.remove(menu);
        this.revalidate();
        this.repaint();
        timer = new Timer(16, this);
        birb.start();
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bgImage, 0,0,this);
        draw(g);
    }

    public void draw(Graphics g){
        switch (birbAnimation){
            case 1:
                g.drawImage(birb.BirbImage1, birb.getX(),birb.getY(),48,48,this);
                break;
            case 2:
                g.drawImage(birb.BirbImage2, birb.getX(),birb.getY(),48,48,this);
                break;
            case 3:
                g.drawImage(birb.BirbImage3, birb.getX(),birb.getY(),48,48,this);
                break;
            case 4:
                g.drawImage(birb.BirbImage4, birb.getX(),birb.getY(),48,48,this);
                break;
            case 5:
                g.drawImage(birb.BirbImage5, birb.getX(),birb.getY(),48,48,this);
                break;
        }
        g.setColor(Color.GREEN);
        g.fillRect(pipes[0].pipePosition,0,pipes[0].pipeWidth,pipes[0].height);
        g.fillRect(pipes[0].pipePosition,pipes[0].height+150,pipes[0].pipeWidth,SCREEN_HEIGHT);
        if(pipes[0].pipePosition <= SCREEN_WIDTH/2){
            g.fillRect(pipes[1].pipePosition,0,pipes[1].pipeWidth,pipes[1].height);
            g.fillRect(pipes[1].pipePosition,pipes[1].height+150,pipes[1].pipeWidth,SCREEN_HEIGHT);
        }
    }

    public void checkCollision(){
        if (birb.getY()>672) {
            birb.stop();
            birb.hitGround(SCREEN_HEIGHT-32);
            timer.stop();
        }
        if((birb.getX()+32 > pipes[0].pipePosition)&&(birb.getX()<pipes[0].pipePosition+pipes[0].pipeWidth)){
            if(birb.getY()<pipes[0].height || birb.getY()+48>pipes[0].height+150) {
                birb.stop();
                timer.stop();
            }
        }
    }

    public void addPipe(){
        pipes[0] = pipes[1];
        pipes[1] = new Pipe();
    }

    public void BirdAnimation(){
        birbAnimation+=1;
        if(birbAnimation==6)
            birbAnimation = 1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        birb.run();
        checkCollision();
        pipes[0].pipeMove();
        if(pipes[0].pipePosition<-pipes[0].pipeWidth)
            addPipe();
        if (pipes[0].pipePosition<SCREEN_WIDTH/2)
            pipes[1].pipeMove();
        BirdAnimation();
        repaint();
    }

    public class MyMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            if(birb.isRunning()){
                birb.jump();
            }
            else
                StartGame();
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
