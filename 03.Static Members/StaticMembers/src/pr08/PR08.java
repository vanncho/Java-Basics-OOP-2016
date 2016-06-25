package pr08;

import java.util.Scanner;

class TriangularPrism{
    private double side;
    private double height;
    private double lenght;

    public TriangularPrism(double side, double height, double lenght) {
        this.side = side;
        this.height = height;
        this.lenght = lenght;
    }

    public double getSide() {
        return side;
    }

    public double getHeight() {
        return height;
    }

    public double getLenght() {
        return lenght;
    }
}

class Cube {
    private double sideLength;

    public Cube(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }
}

class Cylinder{
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }
}

class VolumeCalculator{

    static double calculateTriangularPrismVolume(TriangularPrism triangularPrism){
        double baseSide = triangularPrism.getSide();
        double height = triangularPrism.getHeight();
        double length = triangularPrism.getLenght();
        return (0.5d * baseSide * height * length);
    }

    static double calculateCubeVolume(Cube cube){
        double sideLength = cube.getSideLength();
        return sideLength * sideLength * sideLength;
    }

    static double calculateCylinderVolume(Cylinder cylinder){
        double r = cylinder.getRadius();
        double h = cylinder.getHeight();
        return (Math.PI * h * r * r);
    }
}

public class PR08 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true){
            String[] line = input.nextLine().split("[\\s]+");

            if (line[0].equals("End")){
                break;
            }

            String figureType = line[0];

            switch (figureType){
                case "Cube":
                    double sideLength = Double.valueOf(line[1]);
                    Cube cube = new Cube(sideLength);
                    System.out.printf("%.3f%n", VolumeCalculator.calculateCubeVolume(cube));
                    break;
                case "Cylinder":
                    double radius = Double.valueOf(line[1]);
                    double height = Double.valueOf(line[2]);
                    Cylinder cylinder = new Cylinder(radius, height);
                    System.out.printf("%.3f%n", VolumeCalculator.calculateCylinderVolume(cylinder));
                    break;
                case "TrianglePrism":
                    double baseSide = Double.valueOf(line[1]);
                    double trHeight = Double.valueOf(line[2]);
                    double length = Double.valueOf(line[3]);
                    TriangularPrism triangularPrism = new TriangularPrism(baseSide, trHeight, length);
                    System.out.printf("%.3f%n", VolumeCalculator.calculateTriangularPrismVolume(triangularPrism));
                    break;
            }
        }
    }
}
