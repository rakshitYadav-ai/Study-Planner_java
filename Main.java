import java.util.Scanner;

public class Main {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
StudyPlanner planner = new StudyPlanner();

    while (true) {
        System.out.println("\n===== Study Planner =====");
        System.out.println("1. Add Subject");
        System.out.println("2. Generate Plan");
        System.out.println("3. Show Plan");
        System.out.println("4. Mark Task Done");
        System.out.println("5. Show Progress");
        System.out.println("6. Exit");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Subject name: ");
                String name = sc.nextLine();

                System.out.print("Days left: ");
                int days = sc.nextInt();

                System.out.print("Total topics: ");
                int topics = sc.nextInt();

                planner.addSubject(name, days, topics);
                break;

            case 2:
                planner.generatePlan();
                break;

            case 3:
                planner.showPlan();
                break;

            case 4:
                System.out.print("Subject: ");
                String sub = sc.nextLine();

                System.out.print("Day: ");
                int day = sc.nextInt();

                planner.markTaskDone(sub, day);
                break;

            case 5:
                planner.showProgress();
                break;

            case 6:
                System.out.println("Exiting...");
                return;

            default:
                System.out.println("Invalid choice!");
        }
    }
}

}
