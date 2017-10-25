package playground.java;

public class Weather {

    public void updateWeather(int degrees) {
        String description;
        Color color;
        if (degrees < 5) {
            description = "cold";
            color = Color.BLUE;
        } else if (degrees < 25) {
            description = "mild";
            color = Color.ORANGE;
        } else {
            description = "hot";
            color = Color.RED;
        }
        System.out.println("playground.java.playground.kotlin.Weather is " + description + " with color : " + color);
    }

}
