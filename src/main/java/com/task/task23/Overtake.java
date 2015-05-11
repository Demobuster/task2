package com.task.task23;

/**
 * Class represents an overtake moment. Prints a headline with all information about an overtake 
 * @author Sergey
 */
class Overtake {

    private static String headline;

    public Overtake() {
        Overtake.headline = "";
    }

    public static String getHeadline() {
        return headline;
    }

    public static void setHeadline(String headline) {
        Overtake.headline = headline;
    }

    public static double timeOfOvertakePerformed(Car car1, Car car2) {
        double t = (double) Math.abs(car2.getStartPos() - car1.getStartPos())
                / (double) Math.abs(car1.getSpeed() - car2.getSpeed());
        String overtakeDescription = "Car" + car1.getId() + "(" + car1.getSpeed() + "km/h)"
                + "vsCar" + car2.getId() + "(" + car2.getSpeed() + "km/h)"
                + ". Overtaker is №"
                + ((car1.getSpeed() > car2.getSpeed()) ? car1.getId() : car2.getId());

        setHeadline(overtakeDescription);

        return t;
    }
}
