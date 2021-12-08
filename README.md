## PANDEMIC SIMULATOR

In order to run this program, at least Java 16 is required and Maven must be installed

		brew install maven

## TO COMPILE

	mvn install 
		OR mvn package after the required dependencies have been installed

## TO RUN

	java -jar target/pandemic-1.0.jar <INPUT>
	
## INPUT EXAMPLE

The input must be formatted like the following structure:

	8 7 3 6 "[<4,7>,<4,8>,<5,8>,<6,8>]"


## RUN TESTS

	mvn test

## REMOVE EXECUTABLES

	mvn clean


## THINGS TO IMPROVE

	* Make terminal output optional;
	
	* Handle extremely large grids; probably by capping it
	
	* More extensive testing
	
