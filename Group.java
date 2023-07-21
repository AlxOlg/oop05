import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//*класс Group */
public class Group {

    //*поля */
    private final UUID id;
    private int number;
    private List<Student> students;

    //*конструктор */
    public Group(int number) { // требуется только номер
        this.id = UUID.randomUUID();
        this.number = number;
        this.students = new ArrayList<>();
    }

    //*геттер ИД группы - не используется*/
    public UUID getId() {
        return id;
    }

    //*геттер номер группы */
    public int getNumber() {
        return number;
    }

    //*геттер список студентов группы */
    public List<Student> getStudents() {
        return students;
    }

    //*добавить студента в список группы*/
    public void addStudent(Student student) {
        students.add(student);
    }
}
