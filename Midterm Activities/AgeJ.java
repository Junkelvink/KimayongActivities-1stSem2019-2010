import javax.swing.JOptionPane;

public class AgeJ {
	
	public static void main(String[]args) {
		
    	int age = 0;
    	
    	while(true){
    		try{
    			
    			String kelvin = JOptionPane.showInputDialog("Enter your age: ");
    			if(kelvin == null){
    				System.exit(0);
    			}
    			else if(kelvin != null){
    				age = Integer.parseInt(kelvin);
    			}
		
        		if(age >= 0 && age <= 3) {
          			JOptionPane.showMessageDialog(null, "You are a Baby!");
          			break;
        		}else if(age >= 4 && age <= 12) {
          			JOptionPane.showMessageDialog(null, "You are a Child!");
          			break;
        		}else if(age >= 13 && age <= 19) {
          			JOptionPane.showMessageDialog(null, "You are a Teen!");
          			break;
        		}else if(age >= 20 && age <= 32) {
          			JOptionPane.showMessageDialog(null, "You are a Young Adult!");
          			break;
        		}else if(age >= 33 && age <= 45) {
          			JOptionPane.showMessageDialog(null, "You are in the middle aged!");
          			break;
        		}else if(age >= 46 && age <= 59) {
          			JOptionPane.showMessageDialog(null, "You are an Adult!");
          		break;
        		}else if(age >= 60 && age <= 122) {
          			JOptionPane.showMessageDialog(null, "You are a Senior Citezen!");
         		 	break;
        		}else{
          			JOptionPane.showMessageDialog(null, "-Invalid Age-");
     		 	}
    		}catch(Exception e){
        		JOptionPane.showMessageDialog(null, "-Invalid Input-");
    		}
		}
	}
}