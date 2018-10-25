/**
 * @author YaphetS
 * @date 2018/10/24 7:38 PM
 */
public class Test {
	public static double sqrt(double d, Double precision) {
		double x0 = d, x1, offest,
				prec = precision != null ? precision : 0.01;
		while (true) {



			x1 = (x0 * x0 + d) / 2 / x0;



			offest = x1 * x1 - d;
			if (offest < prec && offest > -prec) {
				return x1;
			}
			x0 = x1;
		}
	}

	public static void main(String[] args){
		System.out.print(sqrt(3,0.01));
	}
}
