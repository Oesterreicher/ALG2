package pkg05_shapes;

/**
 * Nemenny immutable 
 * @author janka
 */
public class Rectangle extends Shape {
    //data
    private double a;
    private double b;
    private double area; //vypocitana
    private double circumference;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
        this.area = area();
        this.circumference = circumference();
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }
    
    private double area() {
        return a*b;
    }

    private double circumference() {
        return a + a + b + b;
    }
    
    //neni ted potreba
    public double getArea() {
        return area;
    }
    
    @Override
    public double computeArea() {
        return area; 
    }

    @Override
    public double computeCircumference() {
        return circumference;
    }
    
    @Override
    public String toString() {
        return "Rectangle{" + "a=" + a + ", b=" + b + '}';
    }
}