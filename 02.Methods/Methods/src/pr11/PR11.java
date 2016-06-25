package pr11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Rectangle{
    private String id;
    private double width;
    private double height;
    private double coordX;
    private double coordY;

    public Rectangle(String id, double width, double height, double coordX, double coordY) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public boolean takeAnotherRectangle(Rectangle two){

        //return      x      <    r.x     + r.width   &&    x        +   width    >   r.x      &&     y       <    r.y     +  r.height  &&       y     +   height    >    r.y;
        return this.coordX < two.coordX + two.width &&
                this.coordX + this.width >= two.coordX &&
                this.coordY <= two.coordY + two.height &&
                this.coordY + this.height > two.coordY;
    }
}

public class PR11 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("[\\s]+");
        int n = Integer.valueOf(tokens[0]);
        int m = Integer.valueOf(tokens[1]);

        HashMap<String, Rectangle> rectData = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] rectTokens = reader.readLine().split("[\\s]+");
            Rectangle currRect = new Rectangle(rectTokens[0],
                               Double.valueOf(rectTokens[1]),
                               Double.valueOf(rectTokens[2]),
                               Double.valueOf(rectTokens[3]),
                               Double.valueOf(rectTokens[4]));
            rectData.put(rectTokens[0], currRect);
        }

        for (int i = 0; i < m; i++) {
            String[] names = reader.readLine().split("[\\s]+");

            Rectangle firstRect = rectData.get(names[0]);
            boolean result = firstRect.takeAnotherRectangle(rectData.get(names[1]));
            System.out.println(result);

        }
    }
}
