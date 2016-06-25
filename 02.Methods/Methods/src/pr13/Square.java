package pr13;

public class Square implements Figure {
    private int side;

    Square(int side){
        this.side = side;
    }

    @Override
    public void draw() {

        System.out.printf("|%s|%n", repeatCharNTimes('-', this.side));
        for (int i = 0; i < this.side - 2; i++) {
            System.out.printf("|%s|%n", repeatCharNTimes(' ', this.side));
        }
        System.out.printf("|%s|%n", repeatCharNTimes('-', this.side));
    }

    public String repeatCharNTimes(char ch, int repeat){

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
