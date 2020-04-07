package fractions;

/**
 *
 * @author Jan Österreicher
 */
public class Fraction {
    /**
     * @param args the command line arguments
     */
    
    private int upperNumber = 0;
    private int lowerNumber = 0;
    
    Fraction(int a, int b) {
        upperNumber = a;
        lowerNumber = b;
    }
    
    Fraction(String s) {
        String[] split = s.split("/");
        upperNumber = Integer.parseInt(split[0]);
        lowerNumber = Integer.parseInt(split[1]);
    }
    
    public int returnUpper() {
        return upperNumber;
    }
    
    public int returnLower() {
        return lowerNumber;
    }
    
    public String returnText() {
        return upperNumber + "/" + lowerNumber;
    }
    
    public void simplifyFraction() {
        int i = greatestCommonDivisor(upperNumber, lowerNumber);
        upperNumber /= i;
        lowerNumber /= i;
    }
    
    private int greatestCommonDivisor(int a, int b) {
        return b == 0 ? a : greatestCommonDivisor(b, a % b);
    }
    
    public static void main(String[] args) {
        Fraction a = new Fraction("3/2");
        Fraction b = new Fraction(1, 2);
        System.out.println(a.returnLower());
        System.out.println(b.returnUpper());
        System.out.println(a.returnText());
        Fraction c = new Fraction(6, 12);
        c.simplifyFraction();
        System.out.println(c.returnText());
        System.out.println(FractionsCalculator.add(a, b).returnText());
        System.out.println(FractionsCalculator.subtract(a, b).returnText());
        System.out.println(FractionsCalculator.multiply(a, b).returnText());
        System.out.println(FractionsCalculator.divide(a, b).returnText());
    }
}