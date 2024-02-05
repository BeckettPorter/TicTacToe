import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class

    public static final int TITLE_BAR_HEIGHT = 23;
    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 500 + TITLE_BAR_HEIGHT;

    public static final int X_OFFSET = 100;

    public static final int Y_OFFSET = 100;

    private Image XIcon, OIcon;
    private TicTacToe t;

    private String winMessage;

    private Square[][] grid;

    public TicTacToeViewer(Square[][] grid, TicTacToe t)
    {
        this.grid = grid;

        this.t = t;

        winMessage = "";

        XIcon = new ImageIcon("Resources/X.png").getImage();
        OIcon = new ImageIcon("Resources/O.png").getImage();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Tic Tac Toe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void drawSquares()
    {
        repaint();
    }

    public void displayWinMessage(String message)
    {
        this.winMessage = message;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Draw the squares
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                grid[i][j].draw(g, (i + 1) * X_OFFSET, (j + 1) * Y_OFFSET + TITLE_BAR_HEIGHT,
                        this, XIcon, OIcon);
            }
        }

        // Draw the column numbers
        for (int i = 0; i < 3; i++)
        {
            int x =  (i + 1) * X_OFFSET + 50;
            int y = Y_OFFSET + TITLE_BAR_HEIGHT - 15;
            g.drawString(String.valueOf(i), x, y);
        }

        // Draw the row numbers
        for (int i = 0; i < 3; i++)
        {
            int x = X_OFFSET - 15;
            int y = (i + 1) * Y_OFFSET + TITLE_BAR_HEIGHT + 100 / 2;
            g.drawString(String.valueOf(i), x, y);
        }

        // Display win message

        if (!(winMessage.isEmpty()))
        {
            g.setColor(Color.BLUE);

            g.drawString(winMessage,WINDOW_WIDTH / 2, WINDOW_HEIGHT - 50);
        }
    }
}