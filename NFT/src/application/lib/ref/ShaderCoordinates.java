package application.lib.ref;

public enum ShaderCoordinates {
	/**
	 * Declares XY values for all four cardinal directions to access the colours in a shader.
	 * @author fembasmat
	 */
	NORTH(48,12),
	EAST(88, 46),
	SOUTH(45,89),
	WEST(21,25);

	private int x;
	private int y;
	
	ShaderCoordinates(int x, int y) {
		this.x = x;
		this.y = y;
	} 
	
	public int getX() { 
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}
