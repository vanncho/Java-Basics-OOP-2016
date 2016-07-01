package pr06;

public class Tomcat extends Cat implements Sound {

    public Tomcat(String name, int age) {
        super(name, age, "Male");
    }

    @Override
    public String produceSound() {
        return "Give me one million b***h";
    }
}
