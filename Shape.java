import java.text.DecimalFormat;
import java.util.Scanner;
import java.lang.Math;

public class Shape {
	
	public static void main(String args[]){
		//variable declaration
		char choice, shape;
		boolean decision = true;
		
		//User Input and DecimalFormat that limits the decimal places into two
		Scanner jk = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");
		
		while(decision){
			try{
				System.out.println("Choose Shape:\nC-circle\nS-square\nR-rectangle\nT-triangle");
				shape = jk.next().charAt(0);
			
				if(shape == 'C' || shape == 'c'){	
					System.out.print("Enter Radius: ");
					double r = jk.nextFloat();
					double areaOfTheCircle = Math.PI * Math.pow(r, 2);
							System.out.println("area of the Circle: " + df.format(areaOfTheCircle) + "\n");
					
					System.out.println("Try Again? Y/N");
					choice = jk.next().charAt(0);
					
					if (choice == 'y' || choice == 'Y')
						decision = true;
					else if (choice == 'n' || choice == 'N') {
						System.out.println("The End!\nThank you!");
						decision = false;
					}else{
						System.out.println("Invalid Response!");
						decision = false;
					}
						
				}else if(shape == 'S' || shape == 's'){
					System.out.print("Enter length of the side of the Square: ");
					double side = jk.nextDouble();
					double areaOfTheSquare = side * side;
						System.out.println("area of the Square: " + areaOfTheSquare);
					
					System.out.println("Try Again? Y/N");
					choice = jk.next().charAt(0);
					
					if (choice == 'y' || choice == 'Y')
						decision = true;
					else if (choice == 'n' || choice == 'N') {
						System.out.println("The End!\nThank You!");
						decision = false;
					}else{
						System.out.println("Invalid Response");
						decision = false;
					}
					
				}else if(shape == 'R' || shape == 'r'){
					System.out.print("Enter the length of the Rectangle: ");
					double length = jk.nextDouble();
			
					System.out.print("Enter the width of the Rectangle: ");
					double width = jk.nextDouble();
				
					double areaOfTheRectangle = length * width;
						System.out.println("area of the Rectangle: " + areaOfTheRectangle);
					
					System.out.println("Try Again? Y/N");
					choice = jk.next().charAt(0);
					
					if (choice == 'y' || choice == 'Y')
						decision = true;
					else if (choice == 'n' || choice == 'N') {
						System.out.println("The End!\nThank You");
						decision = false;
					}else{
						System.out.println("Invalid Response");
						decision = false;
					}
					
				}else if(shape == 'T' || shape == 't'){
					System.out.print("Enter the base of the Triangle: ");
					double base = jk.nextDouble();
				
					System.out.print("Enter the height of the Triangle: ");
					double height = jk.nextDouble();
			
					double areaOfTheTriangle = (base * height) / 2;
						System.out.println("area of the Triangle: " + areaOfTheTriangle);
					
						System.out.println("Try Again? Y/N");
					choice = jk.next().charAt(0);
					
					if (choice == 'y' || choice == 'Y')
						decision = true;
					else if (choice == 'n' || choice == 'N') {
						System.out.println("The End!\nThank You!");
						decision = false;
					}else{
						System.out.println("Invalid Response!");
						decision = false;
					}
				}	
			}catch(Exception e){
				System.out.println("Invalid Input");
				jk.nextLine();
			}	
		}		
	}
}
