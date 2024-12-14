public class unitCircle {

    public static void main(String[] args) {
        double x , y;
        do {
            x = 2.0 * Math.random() - 1.0;
            y = 2.0 * Math.random() - 1.0;
        } while (x * x + y * y > 1.0);
    }
}
