package pandemic;

import java.util.regex.Pattern;
import java.util.regex.MatchResult;
import java.util.ArrayList;
import java.util.List;


public class Input{
	
	private int _gridSize;
	private int _rounds;
	private int _infectionThreshold;
	private int _recoveryThreshold;
	private List <Coordinates> _patientsZero; //List with each element containing a coordinate

	public Input(String args[]) throws Exception {
		try {
			_gridSize = Integer.parseUnsignedInt(args[0]);
			_rounds = Integer.parseUnsignedInt(args[1]);
			_infectionThreshold = Integer.parseUnsignedInt(args[2]);
			_recoveryThreshold = Integer.parseUnsignedInt(args[3]);
		} catch (NumberFormatException e) {
			System.err.println("Argument must be a valid positive integer");
			throw new Exception("Argument must be a valid positive integer");
		}

		Boolean isMatch = Pattern.compile("^\\[(<\\d+,\\d+>,)*<\\d+,\\d+>\\]$") // regex expression to match the input pattern
			.matcher(args[4]).matches();
		if (!isMatch){
			System.err.println("Invalid coordinates format, please use following structure:\n"
						+ "java PandemicSimulator 8 7 3 6 [<4,7>,<4,8>,<5,8>,<6,8>]");
			throw new Exception("Invalid coordinates format");
		}

		Integer[] numbers = Pattern.compile("\\d+") // regex expression to extract the coordinates numbers
			.matcher(args[4])
			.results()					//stream of matchResult instances
			.map(MatchResult::group)	//convert to a stream of strings
			.map(Integer::parseInt)		//convert to a stream of ints
			.toArray(Integer[]::new);

		_patientsZero = new ArrayList<Coordinates>(); //List is abstract, call subclass arraylist constructor to initialize a List
		for(int i = 0; i < numbers.length; i += 2){
			_patientsZero.add(new Coordinates(numbers[i], numbers[i + 1]));
		}
	}

	//Getters
	public int getGridSize() {
		return _gridSize;
	}
	public int getRounds() {
		return _rounds;
	}
	public int getInfectionThreshold() {
		return _infectionThreshold;
	}
	public int getRecoveryThreshold() {
		return _recoveryThreshold;
	}
	public List<Coordinates> getPatientsZero() {
		return _patientsZero;
	}
};
