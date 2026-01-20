package LineComparison;

public class LineComparisonMain {

    public static void main(String[] args) {

        System.out.println("Welcome to Line Comparison Computation Program");

        Line line1 = new Line(1, 1, 4, 5);
        Line line2 = new Line(2, 2, 6, 6);

        System.out.println("Length of Line 1: " + line1.getLength());
        System.out.println("Length of Line 2: " + line2.getLength());

        // UC2: Equality check
        if (line1.equals(line2)) {
            System.out.println("Both lines are equal");
        } else {
            System.out.println("Lines are not equal");
        }

        // UC3: Comparison
        int result = line1.compareTo(line2);
        if (result == 0) {
            System.out.println("Both lines are of equal length");
        } else if (result > 0) {
            System.out.println("Line 1 is longer than Line 2");
        } else {
            System.out.println("Line 1 is shorter than Line 2");
        }
    }
}
