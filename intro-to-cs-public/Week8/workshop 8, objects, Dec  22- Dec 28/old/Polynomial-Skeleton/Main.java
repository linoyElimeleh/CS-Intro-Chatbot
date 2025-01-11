public class Main {
    public static void main(String[] args) {
        Polynomial p = new Polynomial(new double[]{1, -18, 3});

        // #TODO: Step 1, create properly constructor of polynomial so it got presented
        System.out.println("y(x)="+p.toString());

        // #TODO: Step 2, implement evaluate method
        System.out.println();
        for (int x = 0; x < 6; x++) {
            System.out.println("y("+x+")="+p.evaluate(x));
        }

        // #TODO: Step 3, implement derivative method
        System.out.println();
        System.out.println("y'(x)="+p.derivative().toString());

        // #TODO: Step 4, implement findCriticalPoints method
        System.out.println();
        double[] criticalPoints = p.findCriticalPoints(-100,100);
        for (int i = 0; i < criticalPoints.length; i++) {
            System.out.println("y'("+criticalPoints[i]+")=0");
        }

        // #TODO: [EXTRA] - not part of workshop - implement integral method
        System.out.println();
        System.out.println("∫y(x)="+p.integral().toString());

        // #TODO: [EXTRA] - not part of workshop - implement integral method
        System.out.println();
        System.out.println("∫y(1)-∫y(0)="+p.calculateArea(0, 1));
    }
}