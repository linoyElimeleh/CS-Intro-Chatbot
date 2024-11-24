public class PowersOf2V2 {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int v = 1;
		for (int i = 0; i <= N; i++) {
		    System.out.println(i + " " + v);
		    v = 2 * v;
		}
	}
}