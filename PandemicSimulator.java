//import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Thread;

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
		for(int i = 0; i < input.getPatientsZero().size(); i++){ //fill grid with initial values
			int x = input.getPatientsZero().get(i).x();
			int y = input.getPatientsZero().get(i).y();
			grid[x - 1][y - 1].becomeInfected(); //correct for not-zero based indexing
		}
		
		Visualize visual = new Visualize(input.getGridSize());
		for(int i = 0; i < input.getRounds(); i++){
			for(int j = 0; j < grid.length; j++){
				for(int k = 0; k < grid.length; k++){
					System.out.print(grid[j][k].isInfected() ? "X" : "O");
				}
				System.out.println();
			}
			visual.timeLapse(grid);
			try{
				Thread.sleep(1500);
			}
			catch(Exception e){}
			grid = spreadInfection(grid, input);
			System.out.println();
		}
		
	}

	private static Person[][] spreadInfection(Person[][] grid, Input input){
		int infectedNeighbours;
		Person[][] newGrid =  new Person[input.getGridSize()][input.getGridSize()]; // Arrays.stream(grid).map(Person[]::clone).toArray(Person[][]::new);
		for (int i = 0; i < newGrid.length; i++)
			for (int j = 0; j < newGrid[i].length; j++)
				newGrid[i][j] = new Person(grid[i][j].isInfected());
		System.out.println();
		for(int x = 0; x < grid.length; x++){
			for(int y = 0; y < grid.length; y++){
				infectedNeighbours = checkNeighbours(grid, x, y, input.getGridSize());
				//System.out.print(infectedNeighbours);
				if (newGrid[x][y].isInfected() && infectedNeighbours >= input.getRecoveryThreshold()){
					newGrid[x][y].recover();
				}
				else if (infectedNeighbours >= input.getInfectionThreshold()){
					newGrid[x][y].becomeInfected(); 
				//else it keeps the previous value;				
				}	
			}
			//System.out.println();
		}
		return newGrid;
	}

	private static int checkNeighbours(Person[][] grid, int x, int y, int gridBorder){

	//	[x - 1][y - 1]	|	[x - 1][y]	|	[x - 1][y + 1]
	//	--------------------------------------------------
	//	  [x][y - 1]	|	 PERSON		|	 [x][y + 1]
	//	--------------------------------------------------
	//	[x + 1][y - 1]	|	[x + 1][y]	|	[x + 1][y + 1]

	int count = 0;
		for(int i = (x - 1); i <= (x + 1); i++){
			for(int j = (y - 1); j <= (y + 1); j++){
				if (i == x && j == y)
					continue; //is person self
				if(validCoordinate(i, j, gridBorder) == true){
					if(grid[i][j].isInfected())
						count++;
				}
			}
		}
		return count;
	}

	private static Boolean	validCoordinate(int x, int y, int gridBorder){
		if (x < 0 || y < 0 || x >= gridBorder || y >= gridBorder)
			return false;
		return true;
	}
}



//tekst bij visual
// visual person rsize dynamic maken
// tester
// terminal outpu mooi maken
