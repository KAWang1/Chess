
public class Knight extends ChessPiece{

	public Knight(String im, boolean tm, Square lc) {
		super(im, tm, lc);
		
	}

	
	public boolean isMoveLegal(Square dest) {
		int X1 = this.getsquare().getRow();
		int Y1 = this.getsquare().getCol();
		int X2 = dest.getRow();
		int Y2 = dest.getCol();
		if(X1+2 == X2 && Y1 +1 == Y2 || X1-2 == X2 && Y1 -1==Y2 || X1+2==X2 && Y1-1==Y2|| X1-2 == X2 && Y1+1 == Y2 ||
				X1+1 == X2 && Y1 +2 == Y2|| X1-1 == X2 && Y1-2 == Y2|| X1+1 ==X2 && Y1-2==Y2|| X1-1==X2 && Y1+2==Y2) {
			if(dest.getpiece() == null || this.getteam()==false && dest.getpiece().getteam() == true ||
					this.getteam()==true && dest.getpiece().getteam() == false) {
		return true;
	}
		}
		return false;
	}
	
}
