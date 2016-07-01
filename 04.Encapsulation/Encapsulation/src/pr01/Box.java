package pr01;

public class Box {
    private double length, width, height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public double surfaceArea(){
        return 2 * (this.length * this.width) + 2 * (this.length * this.height) + 2 * (this.width * this.height);
    }

    public double lateralSurfaceArea(){
        return 2 * (this.height * this.length) + 2 * (this.width * this.height);
    }

    public double volume(){
        return this.height * this.width * this.length;
    }

    public void setLength(double length) {

        if (length <= 0){
            throw new NumberFormatException("Length cannot be zero or negative.");
        }

        this.length = length;
    }

    public void setWidth(double width) {

        if (width <= 0){
            throw new NumberFormatException("Width cannot be zero or negative.");
        }

        this.width = width;
    }

    public void setHeight(double height) {

        if (height <= 0){
            throw new NumberFormatException("Height cannot be zero or negative.");
        }

        this.height = height;
    }
}
