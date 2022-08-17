import java.util.Scanner;
import java.text.DecimalFormat;
import java.lang.Math;

public class Shape {
	
	public static void main(String args[]){
		//variable declaration
		char choice, shape;
		boolean decision = true;
		boolean condition = true;
		
		//User Input and DecimalFormat that limits the decimal places into two
		Scanner jk = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");
		
		while(decision){
			try{
				System.out.println("Choose Shape:\nC-circle\nS-square\nR-rectangle\nT-triangle");
				shape = jk.next().charAt(0);
				
				if(shape == 'C' || shape == 'c' || shape == 'S' || shape == 's' || shape == 'R' || shape == 'r' || shape == 'T' || shape == 't'){
					jk.nextLine();
				}else {
					System.out.println("NONE OF THE ABOVE");
					jk.nextLine();
				}
						
				if(shape == 'C' || shape == 'c'){	
				
					while(condition){
						System.out.print("Enter Radius: ");
						double r = jk.nextFloat();
						
						if(r > 0){
							condition = true;
							double areaOfTheCircle = Math.PI * Math.pow(r, 2);
							System.out.println("Area of the Circle: " + df.format(areaOfTheCircle) + "\n");
							break;
						}else{
							System.out.println("ERROR!\nYou Cannot Enter Any Negative Value including 0!");
							continue;	
						}	
					}		
					
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
					
					while(condition){
						System.out.print("Enter length of the side of the Square: ");
						double side = jk.nextDouble();
						
						if(side > 0){
							condition = true;
							double areaOfTheSquare = side * side;
							System.out.println("Area of the Square: " + areaOfTheSquare);
							break;
						}else{
							System.out.println("ERROR!\nYou Cannot Enter Any Negative Value including 0!");
							continue;	
						}	
					}		
						
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
					
					double length = 0, width = 0;
					
					while(condition){
						System.out.print("Enter the length of the Rectangle: ");
						length = jk.nextDouble();
			
						if(length > 0){
							condition = true;
							break;
						}else{
							System.out.println("ERROR!\nYou Cannot Enter Any Negative Value including 0!");
							continue;	
						}		
					}
					
					while(condition){
						System.out.print("Enter the width of the Rectangle: ");
						width = jk.nextDouble();
			
						if(width > 0){
							condition = true;
							break;
						}else{
							System.out.println("ERROR!\nYou Cannot Enter Any Negative Value including 0!");
							continue;	
						}	
					}
					
					double areaOfTheRectangle = length * width;
						System.out.println("Area of the Rectangle: " + areaOfTheRectangle);
					
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
					
					double base = 0, height = 0;
					
					while(condition){
						System.out.print("Enter the base of the Triangle: ");
						base = jk.nextDouble();
			
						if(base > 0){
							condition = true;
							break;
						}else{
							System.out.println("ERROR!\nYou Cannot Enter Any Negative Value including 0!");
							continue;	
						}		
					}
					while(condition){
		
						System.out.print("Enter the height of the Triangle: ");
						height = jk.nextDouble();
					
						if(height > 0){
							condition = true;
							break;
						}else{
							System.out.println("ERROR!\nYou Cannot Enter Any Negative Value including 0!");
							continue;	
						}		
					}
					
					double areaOfTheTriangle = (base * height) / 2;
						System.out.println("Area of the Triangle: " + areaOfTheTriangle);
					
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
