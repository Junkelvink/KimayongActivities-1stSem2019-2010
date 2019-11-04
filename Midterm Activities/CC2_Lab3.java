public class CC2_Lab3 {
	public static void main (String []args) {
	
		//set variables for char and long data types e.g. char a, b....
		char a, b, c, d, e, f, g;
		long num1, num2, num3, num4,num5, num6, num7, sum, product, average, remainder;
		
		//set values for the different variables
		a = 'K';
		b = 'E';
		c = 'L';
		d = 'V';
		e = 'I';
		f = 'N';
		g = '!';
		//int values should be the char variables e.g. num1 = a
		num1 = a;
		num2 = b;
		num3 = c;
		num4 = d;
		num5 = e;
		num6 = f;
		num7 = g;
		//assign values using arithmetic solutions
		sum = num1+num2+num3+num4+num5+num6+num7;
		product = num1*num2*num3*num4*num5*num6*num7;
		average = sum/6;
		remainder = product%average;
		
		System.out.println(a + " - " + num1);
		System.out.println(b + " - " + num2);
		System.out.println(c + " - " + num3);
		System.out.println(d + " - " + num4);
		System.out.println(e + " - " + num5);
		System.out.println(f + " - " + num6);
		System.out.println(g + " - " + num7);
		System.out.println(a + "" + b + "" + c + "" + d + "" + e + "" + f + "" + g);
		System.out.println("Sum: " + sum);
		System.out.println("Product: " + product);
		System.out.println("Average: " + average);
		System.out.println("Remainder: " + remainder);
	}
}