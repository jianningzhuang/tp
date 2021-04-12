package seedu.duke.data.assignment;

import seedu.duke.storage.Storable;
import seedu.duke.data.student.Student;
import seedu.duke.exception.InvalidMcqOption;
import seedu.duke.exception.InvalidPercentageException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public abstract class Assignment implements Comparable<Assignment>, Storable {
    protected String name;
    protected String typeOfAssignment;
    protected LocalDate deadline; // Optional field, null can be thrown
    protected float percentageOfOverallGrade; // Optional field, null can be thrown
    protected String assignmentComment;
    protected HashMap<String, Float> studentGrades;

    public String getComments() {
        return assignmentComment;
    }

    public void setComments(String comments) {
        this.assignmentComment = comments;
    }

    public Assignment(String name) {
        this.name = name;
        this.studentGrades = new HashMap<>();

        assert this.name != null : "Assignment name cannot be null";
        assert this.studentGrades != null : "studentGrades cannot be null";
    }

    public HashMap<String, Float> getStudentGrades() {
        return studentGrades;
    }

    public void setStudentGrade(Student student, String grade) throws InvalidPercentageException {
        try {
            Float maxGrade = Float.valueOf(100);
            Float minGrade = Float.valueOf(0);
            String studentNumber = student.getStudentNumber();
            Float gradeFloat = Float.parseFloat(grade);
            if (gradeFloat < minGrade || gradeFloat > maxGrade) {
                throw new InvalidPercentageException();
            }
            studentGrades.put(studentNumber, gradeFloat);
        } catch (NumberFormatException e) {
            throw new InvalidPercentageException();
        } catch (NullPointerException e) {
            throw new InvalidPercentageException();
        }
    }

    public void setStudentGrade(Student student, float grade) throws InvalidPercentageException {
        String studentNumber = student.getStudentNumber();
        Float gradeFloat = Float.valueOf(grade);
        Float maxGrade = Float.valueOf(100);
        Float minGrade = Float.valueOf(0);
        if (gradeFloat < minGrade || gradeFloat > maxGrade) {
            throw new InvalidPercentageException();
        }
        studentGrades.put(studentNumber, gradeFloat);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public float getPercentage() {
        return percentageOfOverallGrade;
    }

    public void setPercentage(float percentage) {
        this.percentageOfOverallGrade = percentage;
    }

    @Override
    public int compareTo(Assignment other) {
        if (this.getDeadline() == null && other.getDeadline() == null) {
            return 0;
        } else if (this.getDeadline() == null) {
            return 1;
        } else if (other.getDeadline() == null) {
            return -1;
        }
        return this.getDeadline().compareTo(other.getDeadline());
    }

    @Override
    public String toString() {
        if (deadline == null) {
            return name + " (" + typeOfAssignment + ") - due date not specified.";
        }
        return name + " (" + typeOfAssignment + ") due by: "
                + deadline.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }

    @Override
    public String toStorage() {
        String storageString = "";
        storageString += this.name;
        storageString += " | ";
        storageString += this.typeOfAssignment;
        storageString += " | ";
        storageString += this.deadline;
        storageString += " | ";
        storageString += this.percentageOfOverallGrade;
        storageString += " | ";
        storageString += this.assignmentComment;
        storageString += " | ";
        storageString += this.studentGrades.size();
        Iterator it = this.studentGrades.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry)it.next();
            storageString += "\n";
            storageString += pair.getKey();
            storageString += " | ";
            storageString += pair.getValue();
            it.remove();
        }
        storageString += "\n";
        return storageString;
    }


    public abstract Answer getAnswers();

    public abstract void setAnswers(Answer answers) throws InvalidMcqOption;

    public ArrayList<Student> getUngraded(ArrayList<Student> students) {
        ArrayList<Student> ungraded = new ArrayList<>();
        for (Student student : students) {
            String studentNumber = student.getStudentNumber();
            if (studentGrades.get(studentNumber) == null) {
                ungraded.add(student);
            }
        }
        return ungraded;
    }
}

