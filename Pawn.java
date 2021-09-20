
public class Pawn extends ChessPiece{
	public Pawn(String im, boolean tm, Square lc) {
		super(im, tm, lc);
		
	}

	
	public boolean isMoveLegal(Square dest) {
		int X1 = this.getsquare().getRow();
		int Y1 = this.getsquare().getCol();
		int X2 = dest.getRow();
		int Y2 = dest.getCol();
		if(this.Notblocked(dest) == true) {
		if(X1==6 || X1==1) {
			if(Y2 == Y1 && X1+2 == X2 && this.getteam() == false) {//black first
				return true;
			}
			if(Y2 == Y1 && X1-2 == X2 && this.getteam() == true) {//white first
				return true;
			}
		}
		//Move
		if(dest.getpiece() == null) {
			if(Y2 == Y1 && X2-1 == X1 && this.getteam() == false) {
				return true;
			}
			if(Y2 == Y1 && X2+1 == X1 && this.getteam() == true) {
				return true;
			}
		}
			//Diagonal
			if(dest.getpiece() != null && dest.getpiece().getteam() == !this.getteam() && X1 < X2) {//black
			if(X1-1 == X2 && Y1-1 == Y2) {
				return true;
			}
			if(X1-1==X2 && Y1+1 == Y2) {
				return true;
			}
			}
			if(dest.getpiece() != null && dest.getpiece().getteam() == !this.getteam() && X1 > X2) {//white
				if(X1+1 == X2 && Y1-1 == Y2) {
					return true;
				}
				if(X1+1==X2&& Y1+1 == Y2) {
					return true;
				}
				}
		}
		return false;
	}
	
}
