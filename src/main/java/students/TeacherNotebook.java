package students;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherNotebook {

    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void readFromFile(Path path) {
        try (Scanner scanner = new Scanner(path)){
            while (scanner.hasNext()) {
                String[] parts = scanner.nextLine().split(";");
                String name = parts[0];
                String className = parts[1];
                Student student = new Student(name, className);
                for (int i = 2; i < parts.length; i++) {
                    student.addGrade(Integer.parseInt(parts[i]));
                }
                students.add(student);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!");
        }
    }

    public List<String> findFailingStudents() {
        return students.stream().filter(student -> student.getGrades().stream().mapToInt(i->i).average().orElseThrow(()->new IllegalStateException("No grades found!")) < 2).map(Student::getName).toList();
    }
}
