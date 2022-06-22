class Problem {

    public static final String UNKNOWN_OPERATOR_MESSAGE = "Unknown operator";
    public static final int MIN_ARGS_LENGTH = 3;

    public static void main(String[] args) {
        if (!validateArgs(args)) {
            System.out.println(Problem.UNKNOWN_OPERATOR_MESSAGE);
        }
        String operator = args[0];
        int x = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);
        switch (operator) {
            case "+":
                System.out.println(x + y);
                break;
            case "-":
                System.out.println(x - y);
                break;
            case "*":
                System.out.println(x * y);
                break;
            default:
                System.out.println(Problem.UNKNOWN_OPERATOR_MESSAGE);
                break;
        }
    }

    private static boolean validateArgs(String[] args) {
        if (args.length < Problem.MIN_ARGS_LENGTH) return false;
        return true;
    }
}