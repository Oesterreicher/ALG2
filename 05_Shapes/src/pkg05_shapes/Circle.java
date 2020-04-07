package pkg05_shapes;

/**
 *
 * @author janka
 */
public class Circle extends Shape { //Circle je typove kompatibilni s Shape, Circle IS A Shape
    //data
    private double r;

    //public Circle(double r) {
    private Circle(double r) {
        this.r = r;
    }
    
    //tovarni metoda - factory method
    public static Circle getInstanceD(double d){
        return new Circle(d/2);
    }
    
    public static Circle getInstanceR(double r){
        return new Circle(r);
    }
    
    public double getR() {
        return r;
    }

    @Override
    public String toString() {
        return "Circle{" + "r=" + r + '}';
    }
    
    @Override
    public double computeArea() {
        return Math.PI*r*r;
    }
    
    @Override
    public double computeCircumference() {
        return 2*Math.PI*r;
    }
    
    public static void main(String[] args) {
        Circle c1 = Circle.getInstanceR(4);
        System.out.println(c1);
        System.out.println(c1.computeArea());
        System.out.println(c1.computeCircumference());
    }
}