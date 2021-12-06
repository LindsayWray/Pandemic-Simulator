class PandemicSimulator{
	public static void main(String args[]) 
	{
		if (args.length != 5){
			System.out.println("Incorrect program usage, please use the following structure:\n"
								+ "java PandemicSimulator 8 7 3 6 [<4,7>,<4,8>,<5,8>,<6,8>]");
		}
		Input input = new Input(args);  //input parsing
		Person[][] grid = new Person [input.getGridSize()][input.getGridSize()];
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid.length; j++){
				grid[i][j] = new Person();
			}
		}
		for(int i = 0; i < input.getPatientsZero().size(); i++){
			int x = input.getPatientsZero().get(i).x();
			int y = input.getPatientsZero().get(i).y();
			grid[x - 1][y - 1].becomeInfected(); //correct for not-zero based indexing
		}
		//spreadInfection(grid);
		//print grid
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid.length; j++){
				System.out.print(grid[i][j].isInfected() ? "X" : "O");
			}
			System.out.println();
		}
	}

	private static Person[][] spreadInfection(Person[][] grid){
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid.length; j++){
				checkNeighbours(grid, i, j);
				// int infectedContacts;

				// isNeighbor
				// grid[i][j] 
			}
			System.out.println();
		}
	}

	private static checkNeighbours(Person[][] grid, int x, int y){
		for(int i = 0; i < 8; i++){
			hgrid[x - 1][y - 1]// top left
			grid[x - 1][y]//top
			grid[x - 1][y + 1] //top right
			grid[x][y - 1] //left
			grid[x][y + 1] // right
			grid[x + 1][y - 1] //bottom left
			grid[x + 1][y] //bottom
			grid[x + 1][y + 1] //bottom right
			if(!validCoordinate())
				continue;
			
		}
	}
}