package pandemic;


public class Person {
	private Boolean _infected;

	public Person(){
		_infected = false;
	};

	public Person(Boolean infected){
		_infected = infected;
	}
	public	Boolean isInfected(){
		return _infected;
	}
	public	void becomeInfected(){
		_infected = true;
	}
	public	void recover(){
		_infected = false;
	}
}
