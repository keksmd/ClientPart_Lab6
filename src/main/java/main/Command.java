/**
 * Класс реализует паттерн command, и служит
 * для вызова разных команд в зависимости от того,что было введено в консоль
 */
package main;

import commands.*;
import utilites.interfaces.methods;

public class Command implements methods {
    /**
     * общий для всех классов-комманд,являющихся наследниками {@link Command}
     * метод,реализующий взаимодействие с коллекцией
     *
     * @return по умолчанию возвращает true, в реализациях boolean,показывающий,была ли выполнена команда успешно
     */
    public Response calling(){
        Response resp = new Response();
        resp.setSuccess(true);
        return resp;
    }

    /**
     * Переменная,где хранится ссылка на наследника {@link Command},который и реализует нужную команду
     */
    Command cmd;
    public Command getCmd() {
        return cmd;
    }

    /**
     * Метод, определяющий команду по вводу str и инициализирующий поле {@link Command#cmd}
     * @param str - текстовое значение команды
     * @return объект,поле cmd,которого имеет реализацию команды переданной в {@link Command#commandReader(String)}
     */
    public Command commandReader(String str){
        Command cm = new Command();
        String[] words = str.split(" ");
       if(words.length ==1){
            switch (str){
                case "help":
                    cm.cmd = new Help();
                    break;
                case "clear":
                    cm.cmd = new Clear();
                    break;
                case "add":
                    cm.cmd = new Add();
                    break;
                case "add_if_max":
                    cm.cmd = new AddIfMax();
                    break;
                case "add_if_min":
                    cm.cmd = new AddIfMin();
                    break;

                case "exit":
                    cm.cmd = new Exit();
                    break;
                case "remove_head":
                    cm.cmd = new RemoveHead();
                    break;
                case "group_counting_by_weapon_type":
                    cm.cmd = new GroupByWeapon();
                    break;
                case "print_field_descending_loyal":
                    cm.cmd = new PrintFieldDescendingLoyal();
                    break;
                case "show":
                   cm.cmd = new Show();
                    break;
                case "info":
                    cm.cmd = new Info();
                    break;

                default:
                    cm.cmd = new NotFound();
            }
        } else if (words.length == 2) {
            switch (words[0]){
                case "update_by_id":
                    cm.cmd = new UpdateById(words[1]);
                    break;

                case "execute_script":
                    cm.cmd = new Execute(words[1]);
                    break;
                case "remove_by_id":
                   cm.cmd = new RemoveById(words[1]);
                    break;
                case "filter_greater_than_height":
                    cm.cmd = new FilterHeight(Integer.parseInt(words[1]));
                    break;
                default:
                    cm.cmd = new NotFound();
            }
        }else{
             cm.cmd = new NotFound();
        }

        return cm.cmd;

    }
}
