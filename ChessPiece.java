import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JOptionPane;

public abstract class ChessPiece {	
	private Image img;
	private boolean team;
	private Square sq;
	private GameBoard b;
	//variable for what team/color i am
	//variable for what Square I'm sitting on 
	
	//Constructor :  you will need some more parameters!
	public ChessPiece(String im, boolean teamcolor, Square location){
		loadImage(im);
		team = teamcolor;
		sq = location;
		location.setpiece(this);
		b=this.getsquare().getboard();
		
	    
		//set up your other variables
 

	}//end constructor
	
	public void setSquare(Square dest)
	{
		sq = dest;
		sq.setpiece(this);
	}
	
	public Square getsquare() {
		return sq;
	}
	public boolean getteam() {
		return team;
	}
	
	public void move(Square location) {
		if (this.isMoveLegal(location)) {
		sq.setpiece(null);
		this.setSquare(location);
		location.setpiece(this);
		
		
	}
		return;
	}
	public boolean Notblocked(Square dest){

		int rowDiff = dest.getRow()-this.getsquare().getRow();
		int colDiff = dest.getCol()-this.getsquare().getCol();

		if(Math.abs(rowDiff) == Math.abs(colDiff)){

			if(rowDiff>0 && colDiff>0){

				for(int x = 1; x<rowDiff; x++){
					if(this.getsquare().getRow()+x >7|| this.getsquare().getCol()+x > 7){
						break;
					}
					if(b.getSquareAt(this.getsquare().getRow() + x,this.getsquare().getCol() + x).getpiece()!=null){

						return false;
					}
				}
				return true;
			}
			if(rowDiff>0  && colDiff<0){
				for(int x = 1; x<rowDiff; x++){
					if(this.getsquare().getRow()+x > 7 || this.getsquare().getCol() -x < 0){
						break;
					}
					if(b.getSquareAt(this.getsquare().getRow()+x, this.getsquare().getCol()-x).getpiece()!=null){
						return false;
					}
				}
				return true;
			}
			if(rowDiff<0  && colDiff>0){
				for(int x = 1; x<Math.abs(rowDiff); x++){
					if(this.getsquare().getRow() - x < 0 || this.getsquare().getCol() + x > 7){
						break;
					}
					if(b.getSquareAt(this.getsquare().getRow()-x, this.getsquare().getCol()+x).getpiece()!=null){
						return false;
					}
				}
				return true;
			}
			if(rowDiff<0 && colDiff<0){
				for(int x = 1; x<Math.abs(rowDiff); x++){
					if(this.getsquare().getRow() - x < 0 || this.getsquare().getCol() - x < 0){
						break;
					}
					if(b.getSquareAt(this.getsquare().getRow()-x, this.getsquare().getCol()-x).getpiece()!=null){
						return false;
					}
				}
				return true;
			}
		}
		if(rowDiff == 0){
			if(colDiff > 0){
				for(int x = 1; x < Math.abs(colDiff); x++){
					if(this.getsquare().getCol()+x >7){
						break;
					}
					if(b.getSquareAt(this.getsquare().getRow(), this.getsquare().getCol()+x).getpiece() != null){
						return false;
					}
				}
				return true;
			}
			if(colDiff < 0){
				for(int x = 1; x < Math.abs(colDiff); x++){
					if(this.getsquare().getCol()-x <0){
						break;
					}
					if(b.getSquareAt(this.getsquare().getRow(), this.getsquare().getCol()-x).getpiece() != null){
						return false;
					}
				}
				return true;
			}
		}
		if(colDiff == 0){
			if(rowDiff > 0){
				for(int x = 1; x < Math.abs(rowDiff); x++){
					if(this.getsquare().getRow()+x < 0 ){
						break;
					}
					if(b.getSquareAt(this.getsquare().getRow()+x, this.getsquare().getCol()).getpiece() != null){
						return false;
					}
				}
				return true;
			}
			if(rowDiff < 0){
				for(int x = 1; x < Math.abs(rowDiff); x++){
					if(this.getsquare().getRow()-x < 0 ){
						break;
					}
					if(b.getSquareAt(this.getsquare().getRow()-x, this.getsquare().getCol()).getpiece() != null){
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}

	//helper function for loading up your image
	private void loadImage( String im ){
		img = Toolkit.getDefaultToolkit().getImage( getClass().getResource(im) );		
	    
		MediaTracker tracker = new MediaTracker (new Component () {});
		tracker.addImage(img, 0);
		//block while reading image
		try { tracker.waitForID (0); }
	        catch (InterruptedException e) {
	        	JOptionPane.showMessageDialog(null, "Error reading file");
	        }
	}//end loadImage

	public void draw(Graphics g){
		g.drawImage(img,0,0,90,90,null,null);
	}
	
	public abstract boolean isMoveLegal(Square dest);
}
