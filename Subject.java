public class Subject {
private String name;
private int daysLeft;
private int totalTopics;


public Subject(String name, int daysLeft, int totalTopics) {
    this.name = name;
    this.daysLeft = daysLeft;
    this.totalTopics = totalTopics;
}

public String getName() {
    return name;
}

public int getDaysLeft() {
    return daysLeft;
}

public int getTotalTopics() {
    return totalTopics;
}


}
