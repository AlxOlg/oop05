import java.util.List;
import java.util.Scanner;

//*класс View */
public class View {

    //*поля */
    private Presenter presenter;

    //*конструктор */
    public View() {
        this.presenter = new Presenter(this);
    }

    //*ввод команд пользователя */
    public void run() {
        System.out.print("\033[H\033[J"); // очистка консоли
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("""
                    Введите номер команды:
                    1 -> Создать новую группу
                    2 -> Показать все группы
                    3 -> Добавить нового студента в группу
                    4 -> Показать всех студентов в группе
                    0 -> Выход
                    """);
                int choice = scanner.nextInt();
                int groupNumber;
                System.out.print("\033[H\033[J"); // очистка консоли
                switch (choice) {
                    case 0: // Выход
                        System.out.print("Работа завершена.");
                        System.exit(0);
                        break;
                    case 1: // Создать новую группу
                        System.out.print("Введите номер новой группы: ");
                        groupNumber = scanner.nextInt();
                        if (presenter.createGroup(groupNumber)) {
                            System.out.println("Группа № " + groupNumber + " создана.");
                        } else {
                            System.out.println("Группа с номером: " + groupNumber + " уже существует!");
                        }
                        break;
                    case 2: // Показать все группы
                        presenter.showAllGroups();
                        break;
                    case 3: // Добавить нового студента в группу
                        System.out.print("\033[H\033[J"); // очистка консоли
                        System.out.print("Введите имя студента: ");
                        String studentName = scanner.next();
                        System.out.print("Введите номер группы: ");
                        groupNumber = scanner.nextInt();
                        if (presenter.createStudent(studentName, groupNumber)) {
                            System.out.println("Студент: " + studentName + " добавлен в группу № " + groupNumber);
                        } else {
                            System.out.println("Группа не существует!");
                        }
                        break;
                    case 4: // Показать всех студентов в группе
                        System.out.print("Введите номер группы: ");
                        groupNumber = scanner.nextInt();
                        if (!presenter.showStudentsOfGroup(groupNumber)) {
                            System.out.println("Группа не существует!");
                        }
                        break;
                    default:
                        System.out.println("Некорректный ввод команды!");
                        break;
                }
                System.out.println();
            }
        }
    }

    //*вывод в консоль всех групп */
    public void printGroups(List<Group> groups) {
        System.out.println("Все группы:");
        for (Group group : groups) {
            System.out.println("группа № " + group.getNumber());
        }
    }

    //*вывод в консоль студентов группы */
    public void printStudents(int groupNumber, List<Student> students) {
        System.out.println("Студенты группы № " + groupNumber + ":");
        for (Student student : students) {
            System.out.println("студент: " + student.getName());
        }
    }
}
