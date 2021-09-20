import java.awt.*;
import javax.swing.*;

public class GameBoard extends JFrame{
	private static final int ROWS = 8, COLS = 8;
	//you'll need a 2d array
	Square board [][] = new Square [ROWS][COLS];
	
	//you'll need variables to keep track of the 1st and 2nd squares that were clicked
	Square first;
	Square second;
	int count=0;
	public GameBoard(){
		super("CHESS");
		
		this.setLayout(new GridLayout(ROWS,COLS));
		boolean black = false;
		//be sure to instantiate the array
		
		
		//now you'll need to birth each element of the array AND add it to the Frame 
		
		for(int i= 0; i < ROWS; i++) {
			 for(int j = 0; j < COLS; j++) {
			
			if ((i+j)%2==0) {
				black = false;
			}
			else {
				black = true;
			}
			
			Square sq = new Square(i, j, this, black);
			board [i][j] = sq;
			this.add(sq);
			 }
		}
		//new Pawn("whitepawn.gif", false, board[1][1]);
		for(int x=0; x<8; x++) {
		new Pawn("BlackPawn.png", false, board[1][x]);
		//new Pawn("whitepawn.gif", false, board[1][2]);
		}
		for(int x=0; x<8; x++) {
			new Pawn("WhitePawn.png", true, board[6][x]);
			//new Pawn("whitepawn.gif", false, board[1][2]);
			}
		new Rook("BlackRook.png", false, board[0][0]);
		new Rook("BlackRook.png", false, board[0][7]);
		new Rook("WhiteRook.png", true, board[7][7]);
		new Rook("WhiteRook.png", true, board[7][0]);
		
		new Knight("BlackKnight.png", false, board[0][1]);
		new Knight("BlackKnight.png", false, board[0][6]);
		new Knight("WhiteKnight.png", true, board[7][6]);
		new Knight("WhiteKnight.png", true, board[7][1]);
		
		new Bishop("BlackBishop.png", false, board[0][2]);
		new Bishop("BlackBishop.png", false, board[0][5]);
		new Bishop("WhiteBishop.png", true, board[7][5]);
		new Bishop("WhiteBishop.png", true, board[7][2]);
		
		new Queen("BlackQueen.png", false, board[0][3]);
		new King("BlackKing.png", false, board[0][4]);
		new Queen("WhiteQueen.png", true, board[7][3]);
		new King("WhiteKing.png", true, board[7][4]);
				this.repaint();
		//some finishing touches
		this.setSize(750,750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

	
	//one of the squares will call this function to tell the board it was clicked
	public void clicked(Square whoGotClicked) {
		if(count==0) {
			first=whoGotClicked;
		JOptionPane.showMessageDialog(this, "It seems that you have clicked: "+ whoGotClicked);
		count++;
		highlight(true,whoGotClicked);
		return;
		}
		
		else {
			highlight(false ,whoGotClicked);
			second = whoGotClicked;
			JOptionPane.showMessageDialog(this, "move from "+ first + " to "+ whoGotClicked);
			count = 0;
		}
		
		
		
		if(first.getpiece() != null && first.getpiece().isMoveLegal(second) && first != second) {
			first.getpiece().move(second);
			
		}
		return;
	}
	
	public void highlight(boolean ishighlighted, Square firstClick) {
		if(ishighlighted&&firstClick.getpiece()!=null) {
		for(int x=0; x<ROWS; x++) {
			for(int y=0; y<COLS; y++) {
				if(firstClick.getpiece().isMoveLegal(board[x][y])) {
				board[x][y].setHighlight(true);
				}
				
			}
		}
		}
		else
			for(int x=0; x<ROWS; x++) {
				for(int y=0; y<COLS; y++) {
					board[x][y].setHighlight(false);
				}
			}
	}
	
	public Square getfirst() {
		return first;
	}
	public Square getsecond() {
		return second;
	}
	//lame main
	public static void main(String[] args) {
		new GameBoard();
	}
	public Square getSquareAt(int one, int two){
		if(one>7||one<0||two>7||two<0) {
			return null;
		}
		return board[one][two];
	}

}
