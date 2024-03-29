/**
 * Класс реализует паттерн command, и служит
 * для вызова разных команд в зависимости от того,что было введено в консоль
 */
package main;

import commands.*;
import exceptions.IncorrectCommandUsing;
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
        System.out.println("Вызвана комманда класса "+this.getClass());
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
        s.append("***** "+this.getClass()+" Details *****\n");
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
/**
     * Переменная,где хранится ссылка на наследника {@link Command},который и реализует нужную команду
     */
    //Command cmd;


    /**
     * Метод, определяющий команду по вводу str
     * @param str - текстовое значение команды
     * @return объект,поле cmd,которого имеет реализацию команды переданной в {@link Command#commandReader(String)}
     */
    public Command commandReader(String str){
        Command cmd = new NotFound();
        String[] words = str.split(" ");
            if (words.length == 1) {
                switch (str.toLowerCase()) {
                    case "help":
                        cmd = new Help();
                        break;
                    case "clear":
                        cmd = new Clear();
                        break;
                    case "add":
                        cmd = new Add();
                        break;
                    case "add_if_max":
                        cmd = new AddIfMax();
                        break;
                    case "add_if_min":
                        cmd = new AddIfMin();
                        break;
                    case "exit":
                        cmd = new Exit();
                        break;
                    case "remove_head":
                        cmd = new RemoveHead();
                        break;
                    case "group_counting_by_weapon_type":
                        cmd = new GroupByWeapon();
                        break;
                    case "print_field_descending_loyal":
                        cmd = new PrintFieldDescendingLoyal();
                        break;
                    case "show":
                        cmd = new Show();
                        break;
                    case "info":
                        cmd = new Info();
                        break;
                    default:
                        cmd = new NotFound();

                }
            } else if (words.length == 2) {
                switch (words[0].toLowerCase()) {
                    case "update_by_id":
                        cmd = new UpdateById(words[1]);
                        break;
                    case "execute_script":
                        cmd = new Execute(words[1]);
                        break;
                    case "remove_by_id":
                        cmd = new RemoveById(words[1]);
                        break;
                    case "filter_greater_than_height":
                        cmd = new FilterHeight(Integer.parseInt(words[1]));
                        break;
                    default:
                        cmd = new NotFound();

                }
            } else {
                cmd = new NotFound();
            }


        return cmd;

    }
}
