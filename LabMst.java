import java.util.*;

class EmptyListException extends Exception {
    public EmptyListException(String message) {
        super(message);
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter which code you want to execute: ");
        Integer y = sc.nextInt();

        switch(y){
            case 1:
                ArrayList<String> names = new ArrayList<String>();
                System.out.println("Enter the name of a student: ");
                String name = sc.nextLine();
                System.out.println("1->add name, 2->remove name,3-> display in alphabatical order");
                Integer x = sc.nextInt();
                try{
                    switch(x){
                        case 1:
                            names.add(name);
                            break;
                        case 2:
                            if (names.isEmpty()) {
                                throw new EmptyListException("Cannot remove. List is empty!");
                            }
                            names.remove(name);
                            break;
                        case 3:
                            if (names.isEmpty()) {
                                throw new EmptyListException("Cannot display. List is empty!");
                            }
                            Collections.sort(names);
                            System.out.println("Ascending: " + names);
                            break;
                        default:
                            System.out.println("Invalid input");
                    }
                }
                catch (EmptyListException e){
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            case 2:
                ArrayList<Integer> numbers = new ArrayList<>();
                ques2 q = new ques2();
                int n = sc.nextInt();
                while(n>0){
                    System.out.println("Enter the number : ");
                    numbers.add(sc.nextInt());
                    n--;
                }
                try {
                    double avg = q.calculateAvg(numbers);
                    System.out.println("Average: " + avg);
                } catch (ArithmeticException e) {
                    System.out.println("Error: Cannot calculate average, the list is empty.");
                }
                break;
        }
    }
}

class ques2{
    double calculateAvg(ArrayList<Integer> numbers){
        int sum = 0;
        for(int i = 0; i < numbers.size(); i++){
            sum += numbers.get(i);
        }
        return (double) sum/numbers.size();
    }
}

