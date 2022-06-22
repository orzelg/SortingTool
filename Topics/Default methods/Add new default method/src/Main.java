interface Flying {
    public static final int KILO = 1000;

    // returns height of flying in meters
    int getHeight();

    // implements a default method getHeightInKm that returns height of flying in km as int type
    default int getHeightInKm() {
        return getHeight() / KILO;
    }
}