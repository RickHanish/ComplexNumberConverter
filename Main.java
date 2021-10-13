import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(true){
			System.out.print("Enter 1 if converting polar to rectangular, 2 if converting rectangular to polar, or 3 to quit: ");
			int conversion = 0;
			try{
				conversion = Integer.parseInt(input.next());
			}
			catch(NumberFormatException ignored){}
			switch(conversion){
				case 1:
					double[] pol = inputPolToRect();
					System.out.println(polToRect(pol));
					break;
				case 2:
					double[] rect = inputRectToPol();
					System.out.println(rectToPol(rect));
					break;
				case 3:
					System.exit(0);
				default:
			}
		}
	}

	public static double[] inputPolToRect(){
		Scanner input = new Scanner(System.in);
		double[] polar = new double[2];
		System.out.print("R = ");
		polar[0] = input.nextDouble();
		System.out.print("Theta = ");
		polar[1] = input.nextDouble();
		return polar;
	}

	public static double[] inputRectToPol(){
		Scanner input = new Scanner(System.in);
		double[] rectangular = new double[2];
		System.out.print("Real = ");
		rectangular[0] = input.nextDouble();
		System.out.print("Imaginary = ");
		rectangular[1] = input.nextDouble();
		return rectangular;
	}

	public static String polToRect(double[] pol){
		double r = pol[0];
		double theta = pol[1];
		double x = Math.sqrt(Math.pow(r, 2) / (1 + Math.pow(Math.tan(degToRad(theta)), 2)));
		double y = x * Math.tan(degToRad(theta));
		if(y>0)
			return x + " + j" + y;
		else
			return x + " - j" + (y*-1);
	}

	public static String rectToPol(double[] rect){
		double x = rect[0];
		double y = rect[1];
		double xSquared = Math.pow(x, 2);
		double ySquared = Math.pow(y, 2);
		double r = Math.sqrt(xSquared + ySquared);
		double theta = radToDeg(Math.atan(y/x));
		return r + " ∠" + theta;
	}

	public static double degToRad(double deg){
		return deg * Math.PI / 180;
	}

	public static double radToDeg(double rad){
		return rad * 180 / Math.PI;
	}
}
