public class ResultService {

    // Task 1 - NullPointerException: PREVENT it with an if check
    public void sendResult(String email) {
        if (email == null) {
            System.out.println("No email on file, result not sent.");
            return;
        }
        System.out.println("Result sent to " + email.toLowerCase());
    }

    // Task 2 - ArithmeticException: CATCH division by zero
    public int classAverage(int totalMarks, int studentCount) {
        try {
            return totalMarks / studentCount;
        } catch (ArithmeticException e) {
            System.out.println("No students in this class yet.");
            return 0;
        }
    }

    // Task 3 - NumberFormatException: CATCH non-numeric input
    public int readMarks(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Marks must be a number, got: " + input);
            return 0;
        }
    }

    // Task 4 - ArrayIndexOutOfBoundsException: CATCH a bad index
    public String getSubject(int index) {
        String[] subjects = {"Maths", "Physics", "Chemistry"};
        try {
            return subjects[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Unknown subject";
        }
    }

    // Tasks 5-7 - THROW exceptions ourselves when data is invalid.
    // "throws" is needed only for the CHECKED AttendanceShortageException.
    public void recordMarks(Student student, int marks) throws AttendanceShortageException {
        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException("Marks must be between 0 and 100, got: " + marks);
        }
        if (student.attendance < 75) {
            throw new AttendanceShortageException(
                student.name + " has " + student.attendance + "% attendance, minimum is 75%");
        }
        student.marks = marks;
    }
}