package game2048;

<<<<<<< HEAD
import java.awt.image.TileObserver;
=======
>>>>>>> a069360b1a31233a88520997ede36991b9e36902
import java.util.Formatter;
import java.util.Observable;


/** The state of a game of 2048.
<<<<<<< HEAD
 *  @author Bryan Aguirre and Natalie Rivea
=======
 *  @author TODO: YOUR NAME HERE
>>>>>>> a069360b1a31233a88520997ede36991b9e36902
 */
public class Model extends Observable {
    /** Current contents of the board. */
    private Board _board;
    /** Current score. */
    private int _score;
    /** Maximum score so far.  Updated when game ends. */
    private int _maxScore;
    /** True iff game is ended. */
    private boolean _gameOver;

    /* Coordinate System: column C, row R of the board (where row 0,
     * column 0 is the lower-left corner of the board) will correspond
     * to board.tile(c, r).  Be careful! It works like (x, y) coordinates.
     */

    /** Largest piece value. */
    public static final int MAX_PIECE = 2048;

    /** A new 2048 game on a board of size SIZE with no pieces
     *  and score 0. */
<<<<<<< HEAD
    //todo
    public Model(int size) {
        _board = new Board(size);
        _score = _maxScore = 0;
        _gameOver = false;
=======
    public Model(int size) {
        // TODO: Fill in this constructor.
>>>>>>> a069360b1a31233a88520997ede36991b9e36902
    }

    /** A new 2048 game where RAWVALUES contain the values of the tiles
     * (0 if null). VALUES is indexed by (row, col) with (0, 0) corresponding
     * to the bottom-left corner. Used for testing purposes. */
    public Model(int[][] rawValues, int score, int maxScore, boolean gameOver) {
<<<<<<< HEAD
        //todo
        int size = rawValues.length;
        _board = new Board(rawValues,score);
        this._score= score;
        this._maxScore= maxScore;
        this._gameOver = gameOver;

=======
        // TODO: Fill in this constructor.
>>>>>>> a069360b1a31233a88520997ede36991b9e36902
    }

    /** Return the current Tile at (COL, ROW), where 0 <= ROW < size(),
     *  0 <= COL < size(). Returns null if there is no tile there.
     *  Used for testing. Should be deprecated and removed.
     */
    public Tile tile(int col, int row) {
        return _board.tile(col, row);
    }

    /** Return the number of squares on one side of the board.
     *  Used for testing. Should be deprecated and removed. */
    public int size() {
        return _board.size();
    }

    /** Return true iff the game is over (there are no moves, or
     *  there is a tile with value 2048 on the board). */
    public boolean gameOver() {
        checkGameOver();
        if (_gameOver) {
            _maxScore = Math.max(_score, _maxScore);
        }
        return _gameOver;
    }

    /** Return the current score. */
    public int score() {
        return _score;
    }

    /** Return the current maximum game score (updated at end of game). */
    public int maxScore() {
        return _maxScore;
    }

    /** Clear the board to empty and reset the score. */
    public void clear() {
        _score = 0;
        _gameOver = false;
        _board.clear();
        setChanged();
    }

    /** Add TILE to the board. There must be no Tile currently at the
     *  same position. */
    public void addTile(Tile tile) {
        _board.addTile(tile);
        checkGameOver();
        setChanged();
    }

    /** Tilt the board toward SIDE. Return true iff this changes the board.
     *
     * 1. If two Tile objects are adjacent in the direction of motion and have
     *    the same value, they are merged into one Tile of twice the original
     *    value and that new value is added to the score instance variable
     * 2. A tile that is the result of a merge will not merge again on that
     *    tilt. So each move, every tile will only ever be part of at most one
     *    merge (perhaps zero).
     * 3. When three adjacent tiles in the direction of motion have the same
     *    value, then the leading two tiles in the direction of motion merge,
     *    and the trailing tile does not.
     */
    public boolean tilt(Side side) {
        boolean changed;
        changed = false;

<<<<<<< HEAD
        // TODO: Fill in this function. idk lol
        //tile.move(col,row + 1 );

        //1

        _board.setViewingPerspective(side);

        // make sure the rows are iterated from the top
        for (int col = 0; col < _board.size() ; col++) {
            for (int row = 0; row < _board.size(); row++) {
                //go from size -1 to 0 instead of 0 to size -1
                Tile tile = tile(col, row);
                if (tile == null) continue;
                //make sure the tile actually exist (null check)
                boolean is_moving = false;
                int destination_row = row + 1;
                for (; destination_row < _board.size(); destination_row++) {
                    Tile destination_tile = tile(col, destination_row);
                    boolean can_i_move_here = true;
                    if ( destination_tile != null) {
                        can_i_move_here = destination_tile.value() == tile.value();
                        if (destination_tile.value() == tile.value()){
                            this._score += destination_tile.value();
                            System.out.println("New Score, ");
                            System.out.println(_score);
                        }
//                        can_i_move_here = true;
                    } //space that u can move to
                    if(!can_i_move_here){
                        break;}


                    is_moving = true;
                    changed = true;


                }
                //if (destination_tile != null)
                // boolean is_moving = true;
                //move destination_tile to destination_tile
                //destination_row should be -1...maybe
                //
                if (is_moving) {
                    _board.move(col, destination_row - 1 , tile );
                }
            }
        }





=======
        // TODO: Fill in this function.
>>>>>>> a069360b1a31233a88520997ede36991b9e36902

        checkGameOver();
        if (changed) {
            setChanged();
        }
<<<<<<< HEAD
        _board.setViewingPerspective(Side.NORTH);
=======
>>>>>>> a069360b1a31233a88520997ede36991b9e36902
        return changed;
    }

    /** Checks if the game is over and sets the gameOver variable
     *  appropriately.
     */
    private void checkGameOver() {
        _gameOver = checkGameOver(_board);
    }

    /** Determine whether game is over. */
    private static boolean checkGameOver(Board b) {
        return maxTileExists(b) || !atLeastOneMoveExists(b);
    }

    /** Returns true if at least one space on the Board is empty.
     *  Empty spaces are stored as null.
     */
    public static boolean emptySpaceExists(Board b) {
<<<<<<< HEAD
        // TODO: Fill in this function. hmm
        //empty spaces returned as null
        //

        for (int col = 0; col < b.size() ; col++) {
            for (int row = 0; row < b.size(); row++) {
                Tile tile = b.tile(col, row);
                if (tile == null)
                    return true;

                // return true if one space on board is empty.
            }
        }
        return false;
    }
    // if not return false end.




=======
        // TODO: Fill in this function.
        return false;
    }
>>>>>>> a069360b1a31233a88520997ede36991b9e36902

    /**
     * Returns true if any tile is equal to the maximum valid value.
     * Maximum valid value is given by MAX_PIECE. Note that
     * given a Tile object t, we get its value with t.value().
     */
    public static boolean maxTileExists(Board b) {
        // TODO: Fill in this function.
<<<<<<< HEAD
        for (int col = 0; col < b.size(); col++) {
            for (int row = 0; row < b.size(); row++) {
                Tile tile = b.tile(col, row);
                if (tile != null) {
                    int tile_value = tile.value();
                    if (tile_value == MAX_PIECE)
                        return true;
                    // if tile exist check to see if it is equal to max value,
                    // tile not empty it exist.
                    // tile doesn't exist we skip
                }

                // return true of false if a value has the maxiumum value
                // check null to see if tile is empty
                // maximum valid value
                // if tile exist check to see if it is equal to max value
            }
        }
        return false;
    }




=======
        return false;
    }

>>>>>>> a069360b1a31233a88520997ede36991b9e36902
    /**
     * Returns true if there are any valid moves on the board.
     * There are two ways that there can be valid moves:
     * 1. There is at least one empty space on the board.
     * 2. There are two adjacent tiles with the same value.
     */
    public static boolean atLeastOneMoveExists(Board b) {
        // TODO: Fill in this function.
<<<<<<< HEAD
        // if something is true of any tile return true
        // if something is not true of any tile then we return false
        for (int col = 0; col < b.size() ; col++) {
            for (int row = 0; row < b.size(); row++) {
                Tile tile = b.tile(col, row);
                if (tile == null)
                    return true;{
                    int tile_value = tile.value();
                    if (tile_value == MAX_PIECE)
                        return true;
                }
                // return true if one space on board is empty.
            }
        }
        return false;
    }






    // return true if one space on board is empty.
    // for each adjacent tile to this one, check to see if have the same value
    // same value return true, if it doesn't apply to condition.
    // another set of if statements, nested
    // outside of for loops if any space is empty return true. (done)
    //starting one tile in at each side(north, south, east, west) b.size() -1




=======
        return false;
    }

>>>>>>> a069360b1a31233a88520997ede36991b9e36902
    /** Returns the model as a string, used for debugging. */
    @Override
    public String toString() {
        Formatter out = new Formatter();
        out.format("%n[%n");
        for (int row = size() - 1; row >= 0; row -= 1) {
            for (int col = 0; col < size(); col += 1) {
                if (tile(col, row) == null) {
                    out.format("|    ");
                } else {
                    out.format("|%4d", tile(col, row).value());
                }
            }
            out.format("|%n");
        }
        String over = gameOver() ? "over" : "not over";
        out.format("] %d (max: %d) (game is %s) %n", score(), maxScore(), over);
        return out.toString();
    }

    /** Returns whether two models are equal. */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (getClass() != o.getClass()) {
            return false;
        } else {
            return toString().equals(o.toString());
        }
    }

    /** Returns hash code of Model’s string. */
    @Override
    public int hashCode() {
        return toString().hashCode();
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> a069360b1a31233a88520997ede36991b9e36902
