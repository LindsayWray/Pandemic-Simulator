## Pandemic Simulator

In order to run this program, at least Java 16 is required and Maven must be installed

	brew install maven

## Compile

	mvn install 
OR after the required dependencies have been installed

	mvn package 

## Run

	java -jar target/pandemic-1.0.jar <INPUT>
	
## Input example

The INPUT consecutively represents a gridsize, number of rounds, infection threshold, recovery threshold, and the coordinates of an x amount of infected persons

It must be formatted like the following structure:

```8 7 3 6 "[<4,7>,<4,8>,<5,8>,<6,8>]"```



## Run tests

	mvn test

## Remove executables

	mvn clean

## Preview
![Simulation](https://user-images.githubusercontent.com/69161963/145284447-84b2cf2f-7985-4b6d-a6da-519cda2accf9.gif)




## Things to improve

* Make terminal output optional;
	
* Handle extremely large grids; probably by capping it
	
* More extensive testing
