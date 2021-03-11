package seedu.duke;

public class Assignment {
    private String name;
//    private String deadline;
//    private float weightage;
    public Assignment(String name) {
        this.name = name;
    }

//    public String getDeadline() {
//        return deadline;
//    }
//
//    public void setDeadline(String deadline) {
//        this.deadline = deadline;
//    }
//
//    public float getWeightage() {
//        return weightage;
//    }
//
//    public void setWeightage(float weightage) {
//        this.weightage = weightage;
//    }

    @Override
    public String toString() {
        return name;
    }
}

