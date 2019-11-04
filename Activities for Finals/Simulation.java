import java.util.Scanner;
import java.text.DecimalFormat;

public class Simulation{
	
	public static void main(String[] args){
		
		//variable declaration
		boolean cond = true;
		//user input & array
		Scanner kelvin = new Scanner(System.in);
		 System.out.println("Enter the number of employee: ");
      	int size = kelvin.nextInt();
      	int numberOfEmployee [] = new int[size];
		
		while(cond){
			
			System.out.println("Trying Simulation");
				
			for(int counter = 0; counter < numberOfEmployee.length; counter++){
				System.out.println("Employee #" + (counter+1));
				kelvin.nextDouble();
				
				
			}
		}
	}
}