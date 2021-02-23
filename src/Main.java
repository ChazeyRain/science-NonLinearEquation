import gui.MainWindow;
import tools.function.NewtonIterationMethod;

public class Main {
    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        System.out.println(new NewtonIterationMethod().findRoots(-2, 0.01, 0.01));
    }
}
