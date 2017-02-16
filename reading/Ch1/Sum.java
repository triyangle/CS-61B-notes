public class Sum {
    public static void main (String[] args) {
        int sum = 0;
        for(int i = 0; i < args.length / 2; i++) {
            sum += Integer.parseInt(args[i]) + Integer.parseInt(args[args.length - 1 - i]);
        }
        sum += (args.length % 2 == 1) ? Integer.parseInt(args[args.length / 2]) : 0;
        System.out.println(sum);
    }
}
