public class Polynomial {
    private final double[] coefficients;
    public Polynomial(double[] coefficients) {
        // TODO: store the minimal array required in order to represent the given polynom
        // coefficients = [4, 2, -1, 5] <=> 4 + 2X - X^2 + 5X^3
        // you should ignore all rightest zeros to keep the coefficients array minimal.
        // coefficients = [3, 1, 0, 0] <=> 3 + X <=> [3, 1]

    }

    public double evaluate(double x) {
        // TODO: Calculate y(x)
    }

    public Polynomial derivative() {
        // TODO: Generate Polynomial that describe y'
    }

    public Polynomial integral() {
        // TODO: Generate Polynomial that describe the integeral of y (use c=0)
    }

    private double[] findZeroPoints(int minX, int maxX) {
        int lastCritical = 0;
        double[] criticalPoints = new double[this.coefficients.length];

        double lastEvaluated = this.evaluate(minX);

        for (double x = minX+1; x <= maxX; x += 1) {
            double eval = this.evaluate(x);
            if (lastEvaluated * eval <= 0) {
                criticalPoints[lastCritical] = x;
                lastCritical++;
                if (eval == 0) {
                    eval = -lastEvaluated;
                }
            }
            lastEvaluated = eval;
        }

        double[] minifiedCriticalPointsArray = new double[lastCritical];
        for (int i=0; i<lastCritical; i++) {
            minifiedCriticalPointsArray[i] = criticalPoints[i];
        }

        return minifiedCriticalPointsArray;
    }

    public double[] findCriticalPoints(int minX, int maxX) {
        // TODO: Find all X's such that y'(x)=0
    }

    public double calculateArea(int minX, int maxX) {
        // TODO: [EXTRA] - not part of the workshop!
        // Find all zero points in order to split the integral zones where sign changed
        // Sum up all absolute values of the integrals at right intervals
    }

    public String toString() {
        String result = "";
        if (this.coefficients[0] != 0) {
            result += this.coefficients[0];
            if (this.coefficients[0] > 0) {
                result = "+"+result;
            }
        }
        for (int i = 1; i < this.coefficients.length; i++) {
            double coefficient = coefficients[i];
            String xPow = "X";
            if (i>1){
                xPow += "^"+i;
            }
            if (coefficient == 0) {
                continue;
            }
            result = coefficient+xPow+result;
            if (coefficient > 0) {
                result = "+"+result;
            }
        }

        if (result == "") {
            return "0";
        }
        if (result.charAt(0) == '+'){
            result = result.substring(1);
        }
        return result;
    }
}
