import java.util.Scanner;

public class Test_Ascend {
    public static void main(String[] args) {
        int lim = Integer.parseInt(args[0]);

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = sc.nextLine();
        String [] parsed = s.split(" ");

        int min = Integer.parseInt(parsed[0]);
        int mid = Integer.parseInt(parsed[1]);
        int max = Integer.parseInt(parsed[2]);
 
        boolean test1 = min < lim && mid < lim && max < lim;
        boolean test2 = min <= mid;
        boolean test3 = mid <= max;
        
        boolean flag = test1 && test2 && test3;
        System.out.println("Ascend\t"+flag);
        sc.close();
    }
}
