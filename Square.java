import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Square extends JPanel implements MouseListener{
	//~~~~ Private Member Variables ~~~~
	private static GameBoard board;
	private ChessPiece piece;
	private int row, col;
	private Boolean highlight=false;
	private Boolean Notblocked=true;
	
	public Boolean getNotblocked() {
		return Notblocked;
	}
	public void setNotblocked(Boolean Nblocked) {
		this.Notblocked = Nblocked;
	}
	public Boolean getHighlight() {
		return highlight;
	}
	public void setHighlight(Boolean h) {
		highlight=h;
		this.repaint();
	}
	/*public void highlight(Boolean isMoveLegal) {
		if (this.getpiece().isMoveLegal(dest)) == true) {
			this.setHighlight(true);
		}
	}
	*/
	
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	//~~~~ Constructors ~~~~
	public Square(int r, int c, GameBoard gb, boolean b){
		board = gb;
		row = r;
		col = c;
		if(b)
			this.setBackground(Color.GRAY);
		else
			this.setBackground(Color.LIGHT_GRAY);
		this.addMouseListener(this);
	}
	public Square(int r, int c, GameBoard gb){
		board = gb;
		row = r;
		col = c;
		this.setBackground(Color.GRAY);		
		this.addMouseListener(this);
	}
	
	//~~~~ some functions to specify the color of this square ~~~~
	public void setColor( int c ){//1 means black, 0 means white
		if(c==1)
			this.setBackground(Color.GRAY);
		else
			this.setBackground(Color.LIGHT_GRAY);
	}

	public void setColor( boolean black ){//true means black, false means white
		if(black)
			this.setBackground(Color.GRAY);
		else
			this.setBackground(Color.LIGHT_GRAY);
	}
	public void setColor( Color c ){
		this.setBackground(c);
	}


	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(piece!=null)
			piece.draw(g);
		
		//if(this.getHighlight() == true ){g.setColor(  new Color( 255, 255, 0, 100) );
		//g.fillRect( 0, 0, this.getWidth(), this.getHeight() );}
		
		if(highlight) {
			g.setColor(  new Color( 255, 255, 0, 100));
					g.fillRect( 0, 0, this.getWidth(), this.getHeight() );}
	}

	
	
	//~~~~ MouseListener stuff ~~~~
	public void mousePressed(MouseEvent arg0) {
		//when I am clicked, I will tell the board that I was clicked!
		board.clicked(this);		
	}

	public void mouseClicked(MouseEvent arg0) {
		
	}

	public void mouseReleased(MouseEvent arg0) {}

	public void mouseEntered(MouseEvent arg0) {}

	public void mouseExited(MouseEvent arg0) {}
	public String toString() {
		String Cord = "("+this.row +","+ this.col+")";
		return Cord; 
	}
public ChessPiece getpiece(){
		return piece;
	}
public void setpiece(ChessPiece p) {
	piece = p;
	this.repaint();
}
public GameBoard getboard() {
	return board;
}
}
