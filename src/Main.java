import gui.MainWindow;
import tools.NewtonIterationMethod;
import tools.ParabolicInterpolation;

public class Main {
    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        window.setVisible(true);
        System.out.println(new NewtonIterationMethod().findRoots(-2, 0.01, 0.01));
    }
}
