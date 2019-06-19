
public class GooseAdapter extends Observable {
	Goose goose;

	public GooseAdapter(Goose goose) {
		this.goose = goose;
	}
 
	public void quack() {
		goose.honk();
	    super.quack();
	}

}
