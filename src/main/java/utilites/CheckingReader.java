/**
 * Класс,(вызвавши много жопной боли у разработчика),метод {@link utilites.CheckingReader#checkyRead(java.lang.String, java.lang.String, java.lang.String, java.lang.String)} которого
 * считывает аргументы команд,анализирует и принимает решение,использовать их,передав далее по цепочке
 * или запросить заново в связи с ошибкой ввода
 *
 */
package utilites;
import exceptions.IncorrectCommandUsing;
import java.util.*;
import java.util.function.Supplier;


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
        String pred0 = null;
        String pred1=null;
        String pred2=null;
        switch (words.length){
            case 1:
            {
                pred0 = words[0].strip();
                break;
            }
            case 2:
            {
                pred0 = words[0].strip();
                pred1 = words[1].strip();
                break;
            }
            case 3:
            {
                pred0 = words[0].strip();
                pred1 = words[1].strip();
                pred2 = words[2].strip();
                break;
            }


        }


        switch (type) {
            case "i", "l" -> {
                if (words.length == 3) {

                    switch (pred0) {
                        
                        case "more":
                            if (pred1.equals("than") && (new Scanner(pred2).hasNextInt() || new Scanner(pred2).hasNextLong())) {
                                if ((Long) o < new Scanner(pred2).nextLong()) {
                                    right = false;
                                }
                            } else {
                                Arrays.stream(words).forEach(w->System.out.print(w+", "));
                                System.out.println();
                                throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead1");
                            }
                            break;
                        case "less":
                            if (pred1.equals("than") && (new Scanner(pred2).hasNextInt() || new Scanner(pred2).hasNextLong())) {
                                if ((Long) o > new Scanner(pred2).nextLong()) {
                                    right = false;
                                }
                            } else {
                                Arrays.stream(words).forEach(w->System.out.print(w+", "));
                                System.out.println();
                                throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead2");
                            }
                            break;
                        default:
                            Arrays.stream(words).forEach(w->System.out.print(w+", "));
                            System.out.println();
                            throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead2");
                    }} else {
                    Arrays.stream(words).forEach(w->System.out.print(w+", "));
                    System.out.println();
                    throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead3");}
                }
            case "f" -> {
                if (words.length == 3) {
                    switch (pred0) {
                        case "more":
                            if (pred1.equals("than") &&( (new Scanner(pred2).hasNextFloat()))||new Scanner(pred2).hasNextDouble()) {
                                if ((Float) o < new Scanner(pred2).nextFloat()) {
                                    right = false;}
                            } else {
                                System.out.printf("хуево вызвал проверку,proove(type,uslovie,obj),usl=%s, words = %n",usl);
                                Arrays.stream(words).forEach(w->System.out.print(w+", "));
                                System.out.println();
                                throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead4");
                            }
                            break;
                        case "less":
                            if (pred1.equals("than") && (new Scanner(pred2).hasNextFloat())) {
                                if ((Float) o >= new Scanner(pred2).nextFloat()) {
                                    right = false;}
                            } else {
                                Arrays.stream(words).forEach(w->System.out.print(w+", "));
                                System.out.println();
                                throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead5");
                            }
                            break;
                        default:
                            Arrays.stream(words).forEach(w->System.out.print(w+", "));
                            System.out.println();
                            throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead6");
                    }
                } else {
                    Arrays.stream(words).forEach(System.out::print);
                    System.out.println();
                    throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead7");}
            }
            case "s" -> {
                if (words.length == 3) {
                    switch (pred0) {
                        case "more":
                            if (pred1.equals("length") && (new Scanner(pred2).hasNextInt())) {
                                if (((String) o).length() <= new Scanner(pred2).nextInt()) {
                                    right = false;
                                }
                            } else {
                                Arrays.stream(words).forEach(w->System.out.print(w+", "));
                                System.out.println();
                                throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead8");
                            }
                            break;
                        case "less":
                            if (pred1.equals("length") && (new Scanner(pred2).hasNextInt())) {
                                if (((String) o).length() >= new Scanner(pred2).nextInt()) {
                                    right = false;
                                }
                            } else {
                                Arrays.stream(words).forEach(w->System.out.print(w+", "));
                                System.out.println();
                                throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead9");
                            }
                            break;
                        default:
                            Arrays.stream(words).forEach(w->System.out.print(w+", "));
                            System.out.println();
                            throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead10");
                    }
                } else if(words.length == 2){
                    switch (pred0){
                    case "is":
                        if(Objects.equals(pred1, "weapon")){
                            if(!o.equals("BOLT_PISTOL") && !o.equals("INFERNO_PISTOL")&& !o.equals("MULTI_MELTA") && !o.equals("COMBI_PLASMA_GUN") && !o.equals("GRENADE_LAUNCHER")){
                                right = false;
                            }
                        }else{
                            Arrays.stream(words).forEach(w->System.out.print(w+", "));
                            System.out.println();
                            throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead10");
                        }
                        break;
                    }
                }else{
                    Arrays.stream(words).forEach(w->System.out.print(w+", "));
                    System.out.println();
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
