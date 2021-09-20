
public class Rook extends ChessPiece {
	public Rook(String im, boolean tm, Square lc) {
		super(im, tm, lc);

	}

	public boolean isMoveLegal(Square dest) {
		int X1 = this.getsquare().getRow();
		int Y1 = this.getsquare().getCol();
		int X2 = dest.getRow();
		int Y2 = dest.getCol();
		if(dest.getpiece() == null || this.getteam()==false && dest.getpiece().getteam() == true ||
				this.getteam()==true && dest.getpiece().getteam() == false) {
			if(this.Notblocked(dest) == true) {
		if (X2 == X1) {
				return true;
		}
		if(Y2 == Y1) {
				return true;
		}
		}
		}
		return false;

	}
}
