package pkg05_shapes;

/**
 *
 * @author janka
 */
public abstract class Shape implements CompareInterface{
    
    public abstract double computeArea();
    
    public abstract double computeCircumference();
    
    @Override
    public boolean isBigger(CompareInterface o) {
        return this.computeArea() < ((Shape)o).computeArea();
    }
}