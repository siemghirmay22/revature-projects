public class Main {

    // Task 8 - try / catch / finally
    static void saveMarks(ResultService portal, Student student, int marks) {
        try {
            portal.recordMarks(student, marks);
            System.out.println("Marks saved for " + student.name + ": " + marks);
        } catch (AttendanceShortageException e) {     // checked
            System.out.println("Not allowed: " + e.getMessage());
        } catch (InvalidMarksException e) {           // unchecked
            System.out.println("Invalid marks: " + e.getMessage());
        } finally {                                   // always runs
            System.out.println("Current marks of " + student.name + ": " + student.marks);
        }
    }

    public static void main(String[] args) {
        ResultService portal = new ResultService();

        // Part A checks
        portal.sendResult(null);
        System.out.println(portal.classAverage(450, 0));
        System.out.println(portal.readMarks("eighty"));
        System.out.println(portal.getSubject(5));

        // Part B checks
        Student priya = new Student("Priya", 90);
        Student asha = new Student("Asha", 60);
        saveMarks(portal, priya, 85);
        saveMarks(portal, asha, 70);
        saveMarks(portal, priya, 120);

        System.out.println("Program finished without crashing.");
    }
}