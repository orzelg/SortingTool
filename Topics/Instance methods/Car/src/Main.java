class Car {

    public static int RASTER = 5;
    public static int ZERO = 0;

    int yearModel;
    String make;
    int speed;

    public void accelerate() {
        speed += Car.RASTER;
    }

    public void brake() {
        speed -= Car.RASTER;
        if (speed < Car.ZERO) {
            speed = Car.ZERO;
        }
    }
}