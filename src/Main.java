import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
    Loto loto = new Loto();
    loto.major();

    }
}

class Loto {
    Scanner sc = new Scanner(System.in);

    private ArrayList<Integer> numbers = new ArrayList<>(100);

    private ArrayList<Integer> firstTicket = new ArrayList<>(10);
    private ArrayList<Integer> secondTicket = new ArrayList<>(10);
    private ArrayList<Integer> thirdTicket = new ArrayList<>(10);

    private ArrayList<Integer> result1 = new ArrayList<>(10);
    private ArrayList<Integer> result2 = new ArrayList<>(10);
    private ArrayList<Integer> result3 = new ArrayList<>(10);

    public void major() throws InterruptedException {
        System.out.print("Do you want to start? >> ");
        String start = sc.next();
        System.out.println();

        if ("Yes".equalsIgnoreCase(start)){
            addNumbers();

            System.out.print("Choose ticket(1-3) >> ");
            int choice = sc.nextInt();
            if(choice == 1){
                System.out.println("You chose ticket №1: " + firstTicket);
            }
            else if(choice == 2){
                System.out.println("You chose ticket №2: " + secondTicket);
            }
            else if(choice == 3){
                System.out.println("You chose ticket №3: " + thirdTicket);
            }

            getNumbers();
        }
        else{
            System.exit(0);
        }
    }

    public void addNumbers(){
        for (int i = 1; i <= 90; i++){
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        for (int j = 0; j <= 10; j++) {
            if (!firstTicket.contains(numbers.get(j))){
                firstTicket.add(numbers.get(j));
            }
        }
        for (int j = 10; j <= 20; j++) {
            if (!secondTicket.contains(numbers.get(j))){
                secondTicket.add(numbers.get(j));
            }
        }
        for (int j = 20; j <= 30; j++) {
            if (!thirdTicket.contains(numbers.get(j))){
                thirdTicket.add(numbers.get(j));
            }
        }
    }

    public void getNumbers() throws InterruptedException {
        Collections.shuffle(numbers);
        System.out.println("\nThe drum is spinning (numbers in () for first ticket, in [] - second and {} - third)");
        TimeUnit.SECONDS.sleep(1);

        for(Integer o : numbers){
            if (firstTicket.contains(o)){
                result1.add(o);
                System.out.print("(" + o + "), ");
                if (result1.size() == 10){
                    System.out.println("\nTicket #1 win!\n");
                    major();
                }
            }
            else if (secondTicket.contains(o)){
                result2.add(o);
                System.out.print("[" + o + "], ");
                if (result2.size() == 10){
                    System.out.println("\nTicket #2 win!\n");
                    major();
                }
            }
            else if (thirdTicket.contains(o)){
                result3.add(o);
                System.out.print("{" + o + "}, ");
                if (result3.size() == 10){
                    System.out.println("\nTicket #3 win!\n");
                    major();
                }
            }
            else {
                System.out.print(o + ", ");
            }

            TimeUnit.MILLISECONDS.sleep(600);
        }
    }

}
