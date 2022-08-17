public class VariablesAndDataTypes {

	public static void main (String []args) {
	
		String News = "The temperature in Baguio City has warmed throughout the years.";
		char Letter = 'A';
		float temperatureAtDawn = 16.0f;
		double temperatureAtNoon = 23.5d;
		byte hoursADay = 24;
		short daysAWeek = 7;
		int weeksPerMonth = 4;
		long monthsEachYear = 12;
		boolean a = true;
		
		if (a) {
			System.out.print(News + "\n\t" + Letter + " recent news article stated the City has been averaging " + temperatureAtDawn + " degrees celsius at dawn and "+ temperatureAtNoon + " at noon.\n\t\t" + "Regardless, lowlanders still feel cold " + hoursADay + " hours a day, " + daysAWeek + " days a week, " + weeksPerMonth + " weeks per month and "+ monthsEachYear + " months each year.");
		}
		else {
			System.out.print("The boolean was changed to a False value.");
		}
	
	}
}
