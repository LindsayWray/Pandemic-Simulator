public class Person {
	private Boolean _infected;

	public Person(){
		_infected = false;
	};

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
