package zomatoapp;
import java.util.Scanner;
public class Zomato {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("press 1 for Breakfast");
		System.out.println("press 2 for Lunch");
		System.out.println("press 3 for Dinner");
		System.out.println("press 4 for Snacs");
		int ch =s.nextInt();
	     switch(ch)
	     {
	     case 1:
	    System.out.println("press 1 for Misal");
		System.out.println("press 2 for Dosa");
		System.out.println("press 3 for Idali");
		System.out.println("press 4 for Vadapav");
		
		int n =s.nextInt();
		 switch(n){
			case 1:System.out.println("Misal is Ready");
			break;
			case 2:System.out.println("Dosa is Ready");
			break;
			case 3:System.out.println("Idali is Ready");
			break;
			case 4:System.out.println("Vadapav is Ready");
			break;
			
		}
	     case 2:
	 	    System.out.println("press 1 for veg Thali");
	 		System.out.println("press 2 for Punjabi Thali");
	 		System.out.println("press 3 for rajshtani Thali");
	 		System.out.println("press 4 for Maharashtrian Thali");
	 		
	 		int n1 =s.nextInt();
	 		 switch(n1){
	 			case 1:System.out.println("veg Thali is Ready");
	 			break;
	 			case 2:System.out.println("Punjabi Thali is Ready");
	 			break;
	 			case 3:System.out.println("rajshtani Thali is Ready");
	 			break;
	 			case 4:System.out.println("Maharashtrian Thali is Ready");
	 			break;
	 			
	 		}
	     case 3:
		 	    System.out.println("press 1 for veg Thali");
		 		System.out.println("press 2 for Punjabi Thali");
		 		System.out.println("press 3 for rajshtani Thali");
		 		System.out.println("press 4 for Maharashtrian Thali");
		 		
		 		int n2 =s.nextInt();
		 		 switch(n2){
		 			case 1:System.out.println("veg Thali is Ready");
		 			break;
		 			case 2:System.out.println("Punjabi Thali is Ready");
		 			break;
		 			case 3:System.out.println("rajshtani Thali is Ready");
		 			break;
		 			case 4:System.out.println("Maharashtrian Thali is Ready");
		 			break;
		 			
		 		}
		}
	
	}	
	}

		
		
	


