import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
* code written 
* by Zoya Klocheva
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> todoList = new ArrayList<>();
        //-------------------------------------------------------------------------------------------------
        for (; ; ) {
            System.out.println("Пожалуйста, введите команду (ADD, EDIT, DELETE, LIST)  и нужный Вам to-do. " +
                    "Для остановки приложения введите EXIT. Спасибо!");

            String command = reader.readLine().trim();

            if (command.equals("LIST")) { //вывод списка дел
                for (String todo : todoList) {
                    int index = todoList.indexOf(todo);
                    System.out.println(index + " " + todo);
                }
                //-------------------------------------------------------------------------------------------------
            } else if (command.matches("ADD\\D+")) { //добавление нового дела в конец списка
                String todo = command.substring(4);
                todoList.add(todo);

            }
            //-------------------------------------------------------------------------------------------------
            else if (command.matches("ADD\\s\\d+\\D+")) {//добавление нового дела в определенное место списка
                String[] arr = command.split("\\s+", 3);
                String index = arr[1];
                String todo = arr[2];
                if (todoList.size() < Integer.parseInt(index)) {
                    todoList.add(todo);
                } else
                    todoList.add(Integer.parseInt(index), todo);
            }
            //-------------------------------------------------------------------------------------------------
            else if (command.startsWith("EDIT")) { //редактирование дела по его номеру
                String[] arr = command.split("\\s+", 3);
                String index = arr[1];
                String newTodo = arr[2];
                if (todoList.size() < Integer.parseInt(index)) {
                    System.out.println("Извините, введите корректный номер дела!");
                } else
                    todoList.set(Integer.parseInt(index), newTodo);
            }
            //-------------------------------------------------------------------------------------------------
            else if (command.startsWith("DELETE")) { //удаление дела по его номеру
                String[] arr = command.split("\\s+", 3);
                String index = arr[1];
                if (todoList.size() < Integer.parseInt(index)) {
                    System.out.println("Извините, введите корректный номер дела!");
                } else
                    todoList.remove(Integer.parseInt(index));
            }
            //--------------------------------------------------------------------------------------------------
            else if (command.equals("EXIT")) { //остановить выполнение
                break;
            }
            //--------------------------------------------------------------------------------------------------
            else {
                System.out.println("Ошибка!");
            }
        }
    }
}

