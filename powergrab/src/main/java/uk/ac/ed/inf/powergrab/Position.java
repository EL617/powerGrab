package uk.ac.ed.inf.powergrab;

public class Position {

	public double latitude;
	public double longitude;
	public final double moveLength = 0.0003;
	public final double w2 = moveLength * Math.cos(Math.PI * 3 / 8);
	public final double h2 = moveLength * Math.sin(Math.PI * 3 / 8);
	public final double w3 = moveLength * Math.cos(Math.PI / 4);
	public final double h3 = moveLength * Math.sin(Math.PI / 4);
	public final double w4 = moveLength * Math.cos(Math.PI / 8);
	public final double h4 = moveLength * Math.sin(Math.PI / 8);
	
	public Position(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	
//	public double getLatitude() {
//		return latitude;
//	}
//
//	public void setLatitude(double latitude) {
//		this.latitude = latitude;
//	}
//
//	public double getLongitude() {
//		return longitude;
//	}
//
//	public void setLongitude(double longitude) {
//		this.longitude = longitude;
//	}

	public Position nextPosition(Direction direction) {
		//next position of the drone when it makes a move in the specified direction
		double longs = this.longitude;
		double lats = this.latitude;
		switch(direction) {
		case E:
			longs = this.longitude + moveLength;
			lats = this.latitude;
			break;
		case ENE:
			longs = this.longitude + w4;
			lats = this.latitude + h4;
			break;
		case ESE:
			longs = this.longitude + w4;
			lats = this.latitude - h4;
			break;
		case N:
			longs = this.longitude;
			lats = this.latitude + moveLength;
			break;
		case NE:
			longs = this.longitude + w3;
			lats = this.latitude + h3;
			break;
		case NNE:
			longs = this.longitude + w2;
			lats = this.latitude + h2;
			break;
		case NNW:
			longs = this.longitude - w2;
			lats = this.latitude + h2;
			break;
		case NW:
			longs = this.longitude - w3;
			lats = this.latitude + h3;
			break;
		case S:
			longs = this.longitude;
			lats = this.latitude - moveLength;
			break;
		case SE:
			longs = this.longitude + w3;
			lats = this.latitude - h3;
			break;
		case SSE:
			longs = this.longitude + w2;
			lats = this.latitude - h2;
			break;
		case SSW:
			longs = this.longitude - w2;
			lats = this.latitude - h2;
			break;
		case SW:
			longs = this.longitude - w3;
			lats = this.latitude - h3;
			break;
		case W:
			longs = this.longitude - moveLength;
			lats = this.latitude;
			break;
		case WNW:
			longs = this.longitude - w4;
			lats = this.latitude + h4;
			break;
		case WSW:
			longs = this.longitude - w4;
			lats = this.latitude - h4;
			break;
		default:
			throw new IllegalArgumentException("Direction Invalid");
		}
		Position position = new Position(lats, longs);
		return position;
	}
	
	public boolean inPlayArea() {
		//test whether or not this Position lies in the PowerGrab play area
		if(this.latitude <= 55.942617 || this.latitude >= 55.946233
				|| this.longitude <= -3.192473 || this.longitude >= -3.184319) {
			return false;
		}
		
		return true;
	}
}
