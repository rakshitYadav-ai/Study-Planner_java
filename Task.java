import java.util.List;

public class Task {
private int day;
private List<String> topics;
private boolean completed;

public Task(int day, List<String> topics) {
    this.day = day;
    this.topics = topics;
    this.completed = false;
}

public int getDay() {
    return day;
}

public List<String> getTopics() {
    return topics;
}

public boolean isCompleted() {
    return completed;
}

public void markCompleted() {
    this.completed = true;
}


}
