package es.com.game.map;

public enum Cardinal {
	NORTH, SOUTH, EAST, WEST/*, UP, DOWN*/
	;
	
	public enum Direction{LEFT, RIGHT;}
	
	
	public void go(Position p) {
		
		switch(this) {
			case EAST:
				p.x++;
				break;
			case NORTH:
				p.y--;
				break;
			case SOUTH:
				p.y++;
				break;
			case WEST:
				p.x--;
				break;
			/*case UP:
				p.z++;
				break;
			case DOWN:
				p.z--;
				break;*/
		}
		
	}
	
	public Cardinal turn(Direction d) {
		Cardinal ret = this;
		switch (this) {
			case NORTH:
				if(d.equals(Direction.LEFT)) 
					ret = WEST;
				else
					ret = EAST;
				break;
			case EAST:
				if(d.equals(Direction.LEFT)) 
					ret = NORTH;
				else
					ret = SOUTH;
				break;
			case SOUTH:
				if(d.equals(Direction.LEFT)) 
					ret = EAST;
				else 
					ret = WEST;
				break;
			case WEST:
				if(d.equals(Direction.LEFT)) 
					ret = SOUTH;
				else 
					ret = NORTH;
				break;
			/*case UP:
				break;
			case DOWN:
			 	break;*/
		}
		return ret;
	}
}
