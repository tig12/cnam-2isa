
public class GooseAdapter implements Quackable {
	private Goose g;

	public GooseAdapter(Goose g) {
		this.g = g;
	}
 
	public void quack() {
		g.honk();
	}

}
