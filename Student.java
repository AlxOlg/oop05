//*класс Student */

import java.util.UUID;

public class Student {

    //*поля */
    private final UUID id;
    private String name;
    private int groupNumber;

    //*конструктор */
    public Student(String name, int groupNumber) { // требуется только имя
        this.id = UUID.randomUUID();
        this.name = name;
        this.groupNumber = groupNumber;
    }

    //*геттер ИД студента - не используется*/
    public UUID getId() {
        return id;
    }

    //*геттер имя студента */
    public String getName() {
        return name;
    }

    //*геттер номер группы - не используется*/
    public int getGroupNumber() {
        return groupNumber;
    }
}
