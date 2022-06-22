class Problem {
    public static void main(String[] args) {
        int result = -1;
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if ("test".equals(args[i])) {
                    result = i;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}