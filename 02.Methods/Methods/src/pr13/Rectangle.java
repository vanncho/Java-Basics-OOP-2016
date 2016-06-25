package pr13;

public class Rectangle implements Figure{
    private int width;
    private int height;

    Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {

        System.out.printf("|%s|%n", repeatCharNTimes('-', this.width));
        for (int i = 0; i < this.height - 2; i++) {
            System.out.printf("|%s|%n", repeatCharNTimes(' ', this.width));
        }
        System.out.printf("|%s|%n", repeatCharNTimes('-', this.width));
    }

    @Override
    public String repeatCharNTimes(char ch, int repeat){

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
