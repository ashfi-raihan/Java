import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;


public class GamaLogic extends JPanel implements ActionListener, KeyListener{

    // ======================== Variables ======================
    int boardWidth;
    int boardHeight;
    int tileSize=25;

    //---- Tiles ----
    // Snake
    Tile snakeHead;
    ArrayList<Tile> snakeBody;
    
    // Food
    Tile food;
    Random random;

    // Game Logics
    Timer gameLoop; // redraws the frame to move the snake
    int valoctyX;
    int valoctyY;
    boolean gameOver = false;

    // ========================== Constructor ==================
    public GamaLogic(int boardHeight, int boardWidth){
        this.boardHeight=boardHeight;
        this.boardWidth=boardWidth;
        this.setPreferredSize(new Dimension(this.boardWidth,this.boardHeight));
        setBackground(Color.BLACK);
        addKeyListener(this);
        setFocusable(true);

        snakeHead = new Tile(5, 5);
        snakeBody = new ArrayList<Tile>();

        valoctyX = 1;
        valoctyY = 0;

        food = new Tile(10,10);
        random = new Random();
        placeFood();

        gameLoop = new Timer(100, this);
        gameLoop.start();
    }

    // =========================== Classes & Function =======================

    // To keep track of all the x & y position of each tiles
    private class Tile{
        int x;
        int y;

        public Tile(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    // to draw the items
    public void draw(Graphics g){

        // Grid lines 
        // for(int i=0; i<boardWidth/tileSize; i++){
        //     // x1,y1 to  x2,y2
        //     g.drawLine(i*tileSize, 0, i*tileSize, boardHeight); // Horizontal
        //     g.drawLine( 0,i*tileSize, boardWidth,i*tileSize); // Vertical
        // }

        // Food 
        g.setColor(Color.red);
        // g.fillRect(food.x*tileSize, food.y*tileSize, tileSize, tileSize);
        g.fill3DRect(food.x*tileSize, food.y*tileSize, tileSize, tileSize,true);     
       
        // Snake Head 
        g.setColor(Color.GREEN);
        g.fill3DRect(snakeHead.x*tileSize, snakeHead.y*tileSize, tileSize, tileSize,true);

        
        // Snake Body
        for(int i=0; i<snakeBody.size(); i++){
            Tile snakePart = snakeBody.get(i);
            g.fill3DRect(snakePart.x*tileSize, snakePart.y*tileSize, tileSize, tileSize,true);
        }
		
		// Score
		g.setFont(new Font("Arial", Font.PLAIN, 16));
		if(gameOver){
			g.setColor(Color.red);
			g.drawString("Game Over: " + String.valueOf(snakeBody.size()),tileSize-16,tileSize);
		}else{
			g.setColor(Color.green);
			g.drawString("Score: " + String.valueOf(snakeBody.size()),tileSize-16,tileSize);
		}			
    }

    public void placeFood(){
        food.x= random.nextInt(boardWidth/tileSize); // 0 to (600/25)=24;
        food.y= random.nextInt(boardHeight/tileSize);
    }

    public boolean collision(Tile tile1, Tile tile2){
        return tile1.x == tile2.x && tile1.y == tile2.y;
    }

    public void move(){
        // eat food
        if(collision(snakeHead, food)){
            snakeBody.add(new Tile(food.x,food.y));
            placeFood();
        }

        // Snake Body
        for(int i=snakeBody.size()-1; i >= 0; i--){ //---------------- ???? ----------------
            Tile snakePart = snakeBody.get(i);
            if(i == 0){ // first part of the body
                snakePart.x = snakeHead.x;
                snakePart.y = snakeHead.y;
            }else{
                Tile prevSnakePart = snakeBody.get(i-1);
                snakePart.x = prevSnakePart.x;
                snakePart.y = prevSnakePart.y; 
            }
        }

        // Snake Head
        snakeHead.x += valoctyX;
        snakeHead.y += valoctyY;

        // Game Over Conditions
        for(int i=0; i<snakeBody.size(); i++){
            Tile snakePart = snakeBody.get(i);
            // Collide with snake head
            if(collision(snakeHead, snakePart)){
                gameOver=true;
            }
        }
		
		if(snakeHead.x*tileSize < 0 || snakeHead.x*tileSize > boardWidth ||
		   snakeHead.y*tileSize < 0 || snakeHead.y*tileSize > boardHeight){
			
			gameOver = true;
		}	
    }

    public void restart(){
        // JOptionPane.showMessageDialog(null,"Score: " + String.valueOf(snakeBody.size()),"Game End", JOptionPane.CANCEL_OPTION);
        snakeBody.clear();
        gameLoop.start();
    }


    // ------------------ Action Perform ----------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint(); // calls draw agian and again 
        if (gameOver) {
            gameLoop.stop();
        }
        
    }

    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_UP && valoctyY != 1){
            valoctyX=0;
            valoctyY=-1;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN && valoctyY != -1){
            valoctyX=0;
            valoctyY=1;
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT && valoctyX != -1){
            valoctyX=1;
            valoctyY=0;
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT && valoctyX != 1){
            valoctyX=-1;                  
            valoctyY=0;
        }
    }

    // Do not need
    @Override
    public void keyTyped(KeyEvent e) {}
    
    @Override
    public void keyReleased(KeyEvent e) {}
    
}
