import java.util.Scanner;

public class Sort{
	public static void main(String [] args){
		
		//user input
		Scanner jk = new Scanner(System.in);
		System.out.print("Enter the Size Of The Array: "); 
		
		//variable and array declaration
		int sizeOfArray = jk.nextInt();
		int array[] = new int[sizeOfArray];	
		double sum = 0;
		double mean= 0;
		int temp = 0;
		
		//entering elements
		for(int i = 0; i < array.length; i++){
			System.out.print("Enter Element #" + (i+1) + ": ");
			array[i] = jk.nextInt();
		}	
		//printing elements in its original order
		System.out.print("Unsorted Array: { ");

		for(int i = 0; i < array.length; i++){	
		System.out.print(array[i] + " ");
		sum += array[i];
		}
		
		System.out.print("}");
		//arrange elements in ascending order
		for(int i = 0; i < array.length; i++){	
			for(int h = 0; h < array.length; h++){
				if(array[i] < array[h]){
					temp = array[i];
					array[i] = array[h];
					array[h] = temp;
				
				}
			}
		}
		
		//printing elements in ascending order
		System.out.println();
		System.out.print("Sorted Array: { " );
		
		for(int i = 0; i < array.length; i++){	
		System.out.print(array[i] + " ");
		}
		
		System.out.println("}");
		
		//computing and printing the mean
		mean = sum/sizeOfArray; 
		
		System.out.println("Mean: " + mean);
	}
}
