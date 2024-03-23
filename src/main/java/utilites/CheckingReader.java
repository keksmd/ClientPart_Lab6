/**
 * Класс,(вызвавши много жопной боли у разработчика),метод {@link utilites.CheckingReader#checkyRead(java.lang.String, java.lang.String, java.lang.String, java.lang.String)} которого
 * считывает аргументы команд,анализирует и принимает решение,использовать их,передав далее по цепочке
 * или запросить заново в связи с ошибкой ввода
 *
 */
package utilites;


import exceptions.IncorrectCommandUsing;

import java.io.IOException;
import java.util.*;
import java.util.function.Supplier;
import exceptions.*;

import static utilites.ServerMessaging.*;


public class CheckingReader {


    public static Object checkyRead(String type,String predicate,String comment,String input)  {
        if (!comment.isEmpty()) {
               System.out.println(comment);
        }
        Scanner sc;
        if (input.equals("sin")) {
                sc = new Scanner(System.in);
        } else {
            sc = new Scanner(input);
        }
        Supplier<?> append;

        Object o = null;
        append = switch (type.toLowerCase()) {
            case "b" -> sc::nextBoolean;
            case "i" -> sc::nextInt;
            case "l" -> sc::nextLong;
            case "f" -> sc::nextFloat;
            case "s" -> sc::nextLine;
            default -> throw new IncorrectCommandUsing("Неверный тип данных");

        };
        try {
            o = switch (type) {
                case "b" -> (Boolean) append.get();
                case "i" -> (Integer) append.get();
                case "l" -> (Long) append.get();
                case "f" -> (Float) append.get();
                case "s" -> (String) append.get();
                default -> o;
            };
            if (!predicate.isEmpty()) {
                if (proove(type, predicate, o)) {
                    return o;
                } else {
                    return checkyRead(type, predicate, ("Значение не подходит по условию,еще раз\n" + comment).replace("Значение не подходит по условию,еще раз\nЗначение не подходит по условию,еще раз\n", "Значение не подходит по условию    ,еще раз\n"), input);
                }
            } else {
                return o;
            }
            //}
        }catch(NoSuchElementException e){
            if(input.equals("sin")){
                return checkyRead(type,predicate,("Вы ошиблись,еще раз\n"+comment).replace("Вы ошиблись,еще раз\nВы ошиблись,еще раз\n","Вы ошиблись,еще раз\n"),"sin");
            }else{
                e.printStackTrace();
                throw new IncorrectCommandUsing("missed datatype in checkingReader");
            }
        }

    }
    private static boolean proove(String type,String usl,Object o){

        String[] words = usl.split(" ");
        boolean right = true;
        if(usl.isEmpty()) return true;

        switch (type) {
            case "i", "l" -> {
                if (words.length == 3) {
                    switch (words[0]) {
                        case "more":
                            if (words[1].equals("than") && (new Scanner(words[2]).hasNextInt() || new Scanner(words[2]).hasNextLong())) {
                                if ((Long) o < new Scanner(words[2]).nextLong()) {
                                    right = false;
                                }
                            } else {
                                throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead1");
                            }
                            break;
                        case "less":
                            if (words[1].equals("than") && (new Scanner(words[2]).hasNextInt() || new Scanner(words[2]).hasNextLong())) {
                                if ((Long) o > new Scanner(words[2]).nextLong()) {
                                    right = false;
                                }
                            } else {
                                throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead2");
                            }
                            break;
                        default:
                            throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead2");
                    }} else {
                    throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead3");}
                }
            case "f" -> {
                if (words.length == 3) {
                    switch (words[0]) {
                        case "more":
                            if (words[1].equals("than") && (new Scanner(words[2]).hasNextFloat())) {
                                if ((Float) o < new Scanner(words[2]).nextFloat()) {
                                    right = false;}
                            } else {
                                throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead4");
                            }
                            break;
                        case "less":
                            if (words[1].equals("than") && (new Scanner(words[2]).hasNextFloat())) {
                                if ((Float) o >= new Scanner(words[2]).nextFloat()) {
                                    right = false;}
                            } else {
                                throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead5");
                            }
                            break;
                        default:
                            throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead6");
                    }
                } else {
                    throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead7");}
            }
            case "s" -> {
                if (words.length == 3) {
                    switch (words[0]) {
                        case "more":
                            if (words[1].equals("length") && (new Scanner(words[2]).hasNextInt())) {
                                if (((String) o).length() <= new Scanner(words[2]).nextInt()) {
                                    right = false;
                                }
                            } else {
                                throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead8");
                            }
                            break;
                        case "less":
                            if (words[1].equals("length") && (new Scanner(words[2]).hasNextInt())) {
                                if (((String) o).length() >= new Scanner(words[2]).nextInt()) {
                                    right = false;
                                }
                            } else {
                                throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead9");
                            }
                            break;
                        default:
                            throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead10");
                    }
                } else if(words.length == 2){
                    switch (words[0]){
                    case "is":
                        if(Objects.equals(words[1], "weapon")){
                            if(!o.equals("BOLT_PISTOL") && !o.equals("INFERNO_PISTOL")&& !o.equals("MULTI_MELTA") && !o.equals("COMBI_PLASMA_GUN") && !o.equals("GRENADE_LAUNCHER")){
                                right = false;
                            }
                        }else{
                            throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead10");
                        }
                        break;
                    }
                }else{
                    throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead11");
                }
            }
            
        }
        return right;
    }

    public static Object checkyRead(String type,String input)  {
        return  checkyRead(type,"","",input);
    }

    public  static Object checkyRead(String type,String comment,String input)  {
        return  checkyRead(type,"",comment,input);
    }
}
