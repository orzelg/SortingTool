class Problem {
    public static final String DEFAULT_MODE = "default";
    public static final String MODE_PARAMETER = "mode";

    public static void main(String[] args) {
        String mode = Problem.DEFAULT_MODE;
        if (args.length > 0) {
            for (int i = 0; i < args.length; i += 2) {
                if (Problem.MODE_PARAMETER.equals(args[i]) && (i + 1) < args.length) {
                    mode = args[i + 1];
                    break;
                }
            }
        }
        System.out.println(mode);
    }
}