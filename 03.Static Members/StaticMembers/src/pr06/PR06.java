package pr06;

class Calculation{
    static final double PLANK_CONSTANT = 6.62606896e-34D;
    static final double PI = 3.14159D;

    static double reducedPlanck(){
        return PLANK_CONSTANT / (2 * PI);
    }
}

public class PR06 {
    public static void main(String[] args) {

        System.out.println(Calculation.reducedPlanck());
    }
}
