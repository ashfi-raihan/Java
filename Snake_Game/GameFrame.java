import javax.swing.*;
public class GameFrame extends JFrame
{
    int boardWidth=600;
    int boardHeight=boardWidth;

    GamaLogic gameLogic;

    public GameFrame()
    {
        super("Snake Game");
        this.setSize(boardWidth,boardHeight);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameLogic = new GamaLogic(boardHeight, boardWidth);
        this.add(gameLogic);
        
        this.pack();
        this.requestFocus();
        this.setVisible(true);
    }
}
