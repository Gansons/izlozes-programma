package loterija;

import java.util.Random;
import java.util.Stack;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class uzd2 {
    public static void main(String[] args) {
        String izvele;
        Stack<Integer> mansSteks = new Stack<>();
        Stack<Integer> izlozetie = new Stack<>();
        Random random = new Random();
        LocalDateTime tagad = LocalDateTime.now();
        DateTimeFormatter laiks = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        String[] darbibas = {"Apskatīt skaitļus","Izlozēt skaitļus", "Apturēt"};

        long atlikusaislaiks = 0; // laiks pēdējai izlozei
        long cooldown = 60000; // 1 minūte milisekundēs

        do {
            izvele = (String) JOptionPane.showInputDialog(null,
                    "Izvēlies darbību", "Darbību saraksts",
                    JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);

            if (izvele == null)
                izvele = "Apturēt";

            switch (izvele) {
                case "Apskatīt skaitļus":
                	if(mansSteks.isEmpty())
                		JOptionPane.showMessageDialog(null, "Nav izlozēti skaitļi, steks ir tukšs", 
                				"Kļūda", JOptionPane.WARNING_MESSAGE);
                	else 
                    JOptionPane.showMessageDialog(null, 
                        "Visi skaitļi: " + mansSteks + 
                        "\nIzlozētie pirmie skaitļi: " + izlozetie);
                	
                    break;

                case "Izlozēt skaitļus":
                    long now = System.currentTimeMillis();
                    if (now - atlikusaislaiks < cooldown) {
                        long secondsLeft = (cooldown - (now - atlikusaislaiks)) / 1000;
                        JOptionPane.showMessageDialog(null,
                                "Jāgaida vēl " + secondsLeft + " sekundes pirms nākamās izlozes!");
                    } else {
                        for (int j = 0; j < 3; j++) {
                            mansSteks.clear(); 

                            for (int i = 0; i < 10; i++) {
                                int num = random.nextInt(10); // 0–9
                                mansSteks.push(num);
                            }
                            
                            if (!mansSteks.isEmpty()) {
                                izlozetie.push(mansSteks.firstElement());
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Pēdējie Steka skaitļi: "+ mansSteks);
                        JOptionPane.showMessageDialog(null, "Izlozētie skaitļi "+ izlozetie +"\n"+ tagad.format(laiks));
                        atlikusaislaiks = now; 
                    }
                    break;
            }
        } while (!izvele.equals("Apturēt"));
    }
}