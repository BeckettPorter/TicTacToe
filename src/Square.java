import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;

    public static final int SQUARE_SIZE = 100;




    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col) {
        this.row = row;
        this.col = col;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }


    public void draw(Graphics g, int x_offset, int y_offset, TicTacToeViewer instigator,
    Image xIcon, Image oIcon)
    {
        // Draw squares
        g.setColor(Color.black);
        g.drawRect(x_offset, y_offset, SQUARE_SIZE, SQUARE_SIZE);


        // If the square is a winning square, paint it green
        if (isWinningSquare)
        {
            g.setColor(Color.green);
            g.fillRect(x_offset, y_offset, SQUARE_SIZE, SQUARE_SIZE);
        }


        // Switch case that sets the correct image
        switch (marker)
        {
            case TicTacToe.X_MARKER:

                g.drawImage(xIcon,
                        x_offset, y_offset,
                        SQUARE_SIZE, SQUARE_SIZE, // Width and height of image
                        instigator); // Reference to TicTacToeViewer

                break;

            case TicTacToe.O_MARKER:

                g.drawImage(oIcon,
                        x_offset, y_offset,
                        SQUARE_SIZE, SQUARE_SIZE, // Width and height of image
                        instigator); // Reference to TicTacToeViewer

                break;

            case TicTacToe.BLANK:

                break;
        }
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }
}
