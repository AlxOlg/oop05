import java.util.List;

//*класс Presenter */
public class Presenter {

    //*поля */
    private View view;
    private Model model;

    //*конструктор */
    public Presenter(View view) {
        this.view = view;
        this.model = new Model();
    }

    //*создать группу */
    public boolean createGroup(int number) {
        return model.createGroup(number);
    }

    //*создать студента */
    public boolean createStudent(String name, int groupNumber) {
        return model.createStudent(name, groupNumber);
    }

    //*показать все группы */
    public void showAllGroups() {
        List<Group> groups = model.getAllGroups();
        view.printGroups(groups);
    }

    //*показать студентов в группе */
    public boolean showStudentsOfGroup(int groupNumber) {
        if (model.getGroupByNumber(groupNumber) != null) {
            List<Student> students = model.getStudentsOfGroup(groupNumber);
            view.printStudents(groupNumber, students);
            return true;
        }
        return false;
    }
}
