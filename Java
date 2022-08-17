import java.io.*;

public class AgeBuff {
	
	public static void main(String[]args)throws IOException{
		
		BufferedReader k = new BufferedReader(new InputStreamReader(System.in));
		int age;
		while(true){
      		try{
      			System.out.println("Enter your Age: ");
      			age = Integer.parseInt(k.readLine());
        		
       	 		if(age >= 0 && age <= 3) {
          			System.out.println("You are a Baby!");
          			break;
        		}else if(age >= 4 && age <= 12) {
          			System.out.println("You are a Child!");
          			break;
        		}else if(age >= 13 && age <= 19) {
          			System.out.println("You are a Teen!");
          			break;
        		}else if(age >= 20 && age <= 32) {
          			System.out.println("You are a Young Adult!");
          			break;
        		}else if(age >= 33 && age <= 45) {
          			System.out.println("You are in the middle aged!");
          			break;
        		}else if(age >= 46 && age <= 59) {
          			System.out.println("You are an Adult!");
          			break;
        		}else if(age >= 60 && age <= 122) {
          			System.out.println("You are a Senior Citezen!");
          			break;
        		}else{
          			System.out.println("-Invalid Age-");
     			}
    		}catch(Exception e){
        		System.out.println("-Invalid Input-");
    		}
		}
	}
}
		
    
