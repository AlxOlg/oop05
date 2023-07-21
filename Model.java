import java.util.ArrayList;
import java.util.List;

//*класс Model */
public class Model {

    //*поля */
    private List<Group> groups;

    //*конструктор */
    public Model() {
        this.groups = new ArrayList<>();
    }

    //*геттер списка групп */
    public List<Group> getAllGroups() {
        return groups;
    }

    //*получить группу по ее номеру или null*/
    public Group getGroupByNumber(int GroupNumber) {
        for(Group group : groups) {
            if(group.getNumber() == GroupNumber) {
                return group;
            }
        }
        return null;
    }

    //*создать группу */
    public boolean createGroup(int groupNumber) {
        if (getGroupByNumber(groupNumber) == null) {
            Group group = new Group(groupNumber);
            groups.add(group);
            return true;
        }
        return false;
    }

    //*создать студента */
    public boolean createStudent(String name, int groupNumber) {
        Group group = getGroupByNumber(groupNumber);
        if (group != null) {
            Student student = new Student(name, groupNumber);
            group.addStudent(student);
            return true;
        }
        return false;
    }

    //*получить список студентов группы */
    public List<Student> getStudentsOfGroup(int groupNumber) {
        Group group = getGroupByNumber(groupNumber);
        if(group != null) {
            return group.getStudents();
        }
        return new ArrayList<>();
    }
}
