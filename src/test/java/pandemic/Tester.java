package pandemic;

import org.junit.Test;
import org.junit.rules.*;
import static org.junit.Assert.*;


public class Tester {

	@Test
	public void testValidInput() throws Exception 
	{
		String[] args = {"8", "7", "3", "6", "[<4,7>,<4,8>,<5,8>,<6,8>]"}; //input from example
		Input input = new Input(args);
		assertEquals(4, input.getPatientsZero().size());
		assertEquals(8, input.getGridSize());
		assertEquals(3, input.getInfectionThreshold());
		assertEquals(4, input.getPatientsZero().get(1).x());
		assertEquals(8, input.getPatientsZero().get(1).y());
	}
	@Test
	public void testValidInput2() throws Exception 
	{
		String[] args = {"30", "40", "3", "5", "[<1,1>,<4,8>,<5,8>,<38,8>,<38,9>,<40,1>]"}; //test large grid
		Input input = new Input(args);
		assertEquals(6, input.getPatientsZero().size());
		assertEquals(40, input.getRounds());
		assertEquals(5, input.getRecoveryThreshold());
	}

	@Test(expected = Exception.class)
	public void testInvalidInput() throws Exception
	{
		String[] args = {"8", "7", "3", "6", "[<4,7>,<4,8> ,<5,8>,<6,8>]"}; //space inserted in coordinates
		Input input = new Input(args);
	}
	@Test(expected = Exception.class)
	public void testInvalidInput2() throws Exception
	{
		String[] args = {"8", "7", "A", "6", "[<4,7>,<4,8>,<5,8>,<6,8>]"}; //letter instead of integer
		Input input = new Input(args);
	}
	@Test(expected = Exception.class)
	public void testInvalidInput3() throws Exception
	{
		String[] args = {"8", "7", "-3", "6", "[<4,7>,<4,8>,<5,8>,<6,8>]"}; //negative input
		Input input = new Input(args);
	}
}
