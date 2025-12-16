package loterija;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class uzd2 {
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		String izvele, vards = " ";
		Stack<Integer> mansSteks = new Stack<>();
		Stack<Integer> laimeSk = new Stack<>();
		Random random = new Random();


		String[] darbibas = {"Apskatīt skaitļus","Izlozēt skaitļus", "Apturēt"};
		
		do {
			izvele = (String) JOptionPane.showInputDialog(null, 
					"Izvēlies darbību", "Darbību saraksts", 
					JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			
			if(izvele == null)
				izvele = "Apturēt";
			
			switch(izvele) {
			
			case "Apskatīt skaitļus":
				
				break;
				
			case "Izlozēt skaitļus":
				
					Thread.sleep(60000); // nogaida 1min
				for (int i = 0; i < 10; i++) {
		            int num = random.nextInt(10); // Ģenerē skaitli no 0-9
		            mansSteks.push(num);
		            System.out.println("Pushed: " + num);

		        }
				  System.out.println("Final Stack: " + mansSteks);

				break;
				
			}
		}while(!izvele.equals("Apturēt"));
		
		
}
	}
