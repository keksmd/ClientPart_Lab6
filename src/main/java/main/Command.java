/**
 * Класс реализует паттерн command, и служит
 * для вызова разных команд в зависимости от того,что было введено в консоль
 */
package main;

import commands.*;
import utilites.interfaces.methods;

import java.lang.reflect.Field;

public class Command implements methods {
    String[] args = new String[0];

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    /**
     * общий для всех классов-комманд,являющихся наследниками {@link Command}
     * метод,реализующий взаимодействие с коллекцией
     *
     * @return по умолчанию возвращает true, в реализациях boolean,показывающий,была ли выполнена команда успешно
     */
    public Request calling(){
        Request request = new Request();
        request.setCommandToExecute(this);
        request.getCommandToExecute().setName(this.getName());
        return request;
    }
    private String name = "command" ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("***** ").append(this.getClass()).append(" Details *****\n");
        for(Field f: this.getClass().getFields()){
            try {
                f.setAccessible(true);
                s.append(f.getName()).append("=").append(f.get(this).toString()).append("\n");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        s.append("*****************************");

        return s.toString();
    }
    public Command() {
    }
    //Command cmd;


    /**
     * Метод, определяющий команду по вводу str
     *
     * @return объект,поле cmd,которого имеет реализацию команды переданной в  {@param str - текстовое значение команды}
     */
    public static Command commandReader(String str){
        Command cmd = new NotFound();
        String[] words = str.split(" ");
            if (words.length == 1) {
                cmd = switch (str.toLowerCase()) {
                    case "help" -> new Help();
                    case "clear" -> new Clear();
                    case "add" -> new Add();
                    case "add_if_max" -> new AddIfMax();
                    case "add_if_min" -> new AddIfMin();
                    case "exit" -> new Exit();
                    case "remove_head" -> new RemoveHead();
                    case "group_counting_by_weapon_type" -> new GroupByWeapon();
                    case "print_field_descending_loyal" -> new PrintFieldDescendingLoyal();
                    case "show" -> new Show();
                    case "info" -> new Info();
                    default -> new NotFound();
                };
            } else if (words.length == 2) {
                cmd = switch (words[0].toLowerCase()) {
                    case "update_by_id" -> new UpdateById(words[1]);
                    case "execute_script" -> new Execute(words[1]);
                    case "remove_by_id" -> new RemoveById(words[1]);
                    case "filter_greater_than_height" -> new FilterHeight(Integer.parseInt(words[1]));
                    default -> new NotFound();
                };
            } else {
                cmd = new NotFound();
            }


        return cmd;

    }
}
