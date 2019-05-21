
  
public class MainHeart {
    public static void main (String[] args) {
		HeartModelInterface model = new HeartModel();
        ControllerInterface controller = new HeartController(model);
    }
}

