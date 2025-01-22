

import java.util.ArrayList;
class Student{
    private String studentName;
    private int studentId ;
    private ArrayList <Subject> subjects;

    //Constructor
    public Student(String studentName, int studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.subjects = new ArrayList<>();
    }

    //Method to add subject
    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }
    //getters
    public String getStudentName() {
        return studentName;
    }
    public int getStudentId() {
        return studentId;
    }
}
class Subject {
    private String subjectName;
    private int score;

    //Constructors
    public Subject(String subjectName, int score) {
        this.subjectName = subjectName;
        this.score = score;
    }

    public String getSubjectName() {
        return subjectName;
    }
    public int getScore() {
        return score;
    }
}
class GradeCalculator {
    public double calculateAverage(Student student) {
        ArrayList<Subject> subjects = student.getSubjects();
        int totalScore = 0;
        for (Subject subject : subjects) {
            totalScore += subject.getScore();
        }
        return subjects.size() > 0 ? (double) totalScore / subjects.size() : 0;
    }

    public char calculateGrade(double average) {
        if (average >= 90) return 'A';
        else if (average >= 80) return 'B';
        else if (average >= 70) return 'C';
        else if (average >= 60) return 'D';
        else return 'F';
    }
}
public class StudentGrades {
    public static void main(String[] args) {
        Student s1 = new Student("John", 
        211006);
        s1.addSubject(new Subject("Maths", 90));
        s1.addSubject(new Subject("Science", 85));
        
        //Creating object of GradeCalculator
        GradeCalculator gradeCalculator = new GradeCalculator();

        //Calculating average and grade
        double average = gradeCalculator.calculateAverage(s1);
        char grade = gradeCalculator.calculateGrade(average); 

        //Displaying the result
        System.out.println("Student Name : " + s1.getStudentName());
        System.out.println("Student ID : " + s1.getStudentId());
        System.out.println("Subjects and Scores : ");
        for (Subject subject : s1.getSubjects()) {
            System.out.println(subject.getSubjectName() + " : " + subject.getScore());
        }

        System.out.println("Average : " + average);
        System.out.println("Final Grade : " + grade);
    }
}
