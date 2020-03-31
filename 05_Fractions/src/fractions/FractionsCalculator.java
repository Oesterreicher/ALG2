package fractions;

/**
 *
 * @author Jan Österreicher
 */
public class FractionsCalculator {
    private FractionsCalculator() {
    }
    
    private static int greatestCommonDivisor(int a, int b) {
        return b == 0 ? a : greatestCommonDivisor(b, a % b);
    }
    
    public static Fraction add(Fraction a, Fraction b) {
        int lower = (a.returnLower()*b.returnLower()) / greatestCommonDivisor(a.returnLower(), b.returnLower());
        int upper = a.returnUpper()*(lower/a.returnLower()) + b.returnUpper()*(lower/b.returnLower());
        Fraction c = new Fraction(upper, lower);
        c.simplifyFraction();
        return c;
    }
    
    public static Fraction subtract(Fraction a, Fraction b) {
        int lower = (a.returnLower()*b.returnLower()) / greatestCommonDivisor(a.returnLower(), b.returnLower());
        int upper = a.returnUpper()*(lower/a.returnLower()) - b.returnUpper()*(lower/b.returnLower());
        Fraction c = new Fraction(upper, lower);
        c.simplifyFraction();
        return c;
    }
    
    public static Fraction multiply(Fraction a, Fraction b) {
        Fraction c = new Fraction(a.returnUpper()*b.returnUpper(), a.returnLower()*b.returnLower());
        c.simplifyFraction();
        return c;
    }
    
    public static Fraction divide(Fraction a, Fraction b) {
        Fraction c = new Fraction(a.returnUpper()*b.returnLower(), a.returnLower()*b.returnUpper());
        c.simplifyFraction();
        return c;
    }
}