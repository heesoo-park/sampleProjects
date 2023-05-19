package todoList.todo;

import todoList.todo.dao.TodoList;
import todoList.todo.menu.Menu;
import todoList.todo.service.TodoUtil;

import java.util.Scanner;

public class TodoMain {
    public static void start() {
        Scanner sc = new Scanner(System.in);
        TodoList l = new TodoList();
        boolean isList = false;
        boolean quit = false;

        Menu.displaymenu();
        do {
            Menu.prompt();
            isList = false;
            String choice = sc.next();
            switch (choice) {
                case "add":
                    TodoUtil.createItem(l);
                    break;
                case "del":
                    TodoUtil.deleteItem(l);
                    break;
                case "edit":
                    TodoUtil.updateItem(l);
                    break;
                case "ls":
                    TodoUtil.listAll(l);
                    break;
                case "ls_name_asc":
                    l.sortByName();
                    System.out.println("제목순으로 정렬하였습니다.");
                    isList = true;
                    break;
                case "ls_name_desc":
                    l.sortByName();
                    l.reverseList();
                    System.out.println("제목역순으로 정렬하였습니다.");
                    isList = true;
                    break;
                case "ls_date":
                    l.sortByDate();
                    System.out.println("날짜순으로 정렬하였습니다.");
                    isList = true;
                    break;
                case "help":
                    Menu.displaymenu();
                    break;
                case "exit":
                    quit = true;
                    break;
                default:
                    System.out.println("정확한 명령어를 입력하세요. (도움말 - help)");
                    break;
            }

            if (isList) TodoUtil.listAll(l);
        } while (!quit);
    }
}
