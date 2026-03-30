import java.util.*;

public class StudyPlanner {


private List<Subject> subjects = new ArrayList<>();
private Map<String, List<Task>> plan = new HashMap<>();

public void addSubject(String name, int days, int topics) {
    subjects.add(new Subject(name, days, topics));
}

public void generatePlan() {
    if (subjects.isEmpty()) {
        System.out.println("No subjects added!");
        return;
    }

    for (Subject sub : subjects) {
        List<Task> taskList = new ArrayList<>();

        int topics = sub.getTotalTopics();
        int days = sub.getDaysLeft();
        int perDay = (int) Math.ceil((double) topics / days);

        int topicCounter = 1;

        for (int d = 1; d <= days; d++) {
            List<String> dailyTopics = new ArrayList<>();

            for (int i = 0; i < perDay && topicCounter <= topics; i++) {
                dailyTopics.add("Topic " + topicCounter);
                topicCounter++;
            }

            if (!dailyTopics.isEmpty()) {
                taskList.add(new Task(d, dailyTopics));
            }
        }

        plan.put(sub.getName(), taskList);
    }

    System.out.println("Study plan generated successfully!");
}

public void showPlan() {
    for (String subject : plan.keySet()) {
        System.out.println("\nSubject: " + subject);
        for (Task t : plan.get(subject)) {
            System.out.println("Day " + t.getDay() + " -> " + t.getTopics()
                    + " | Done: " + t.isCompleted());
        }
    }
}

public void markTaskDone(String subject, int day) {
    if (!plan.containsKey(subject)) {
        System.out.println("No such subject!");
        return;
    }

    for (Task t : plan.get(subject)) {
        if (t.getDay() == day) {
            t.markCompleted();
            System.out.println("Marked as completed!");
            return;
        }
    }

    System.out.println("Invalid day!");
}

public void showProgress() {
    for (String subject : plan.keySet()) {
        List<Task> tasks = plan.get(subject);

        long completed = tasks.stream().filter(Task::isCompleted).count();

        System.out.println(subject + ": " + completed + "/" + tasks.size());
    }
}


}
