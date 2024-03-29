
// Определить класс Reader, хранящий такую информацию о пользователе библиотеки:ФИО,номер читательского билета,факультет,дата рождения,телефон.Методы takeBook(),
// returnBook().Разработать программу, в которой создается массив объектов данного класса.Перегрузить методы takeBook(), returnBook():
//- takeBook, который будет принимать количество взятых книг. Выводит на консоль сообщение "Петров В. В. взял 3 книги".
//- takeBook, который будет принимать переменное количество названий книг. Выводит на консоль сообщение "Петров В. В. взял книги: Приключения, Словарь, Энциклопедия".
//- takeBook, который будет принимать переменное количество объектов класса Book (создать новый класс, содержащий имя и автора книги). Выводит на консоль сообщение
// "Петров В. В. взял книги: Приключения, Словарь, Энциклопедия". Аналогичным образом перегрузить метод returnBook(). Выводит на консоль сообщение "Петров В. В. вернул книги:
// Приключения, Словарь, Энциклопедия". Или  "Петров В. В. вернул 3 книги".

public class Main {
    public static void main(String[] args) {
        Reader reader1 = new Reader("Петров В. В.", 123456, "Факультет 1", "01.01.1990", "+123456789");
        Reader reader2 = new Reader("Иванова А. С.", 789012, "Факультет 2", "02.02.1995", "+987654321");

        reader1.takeBook(3);
        reader1.takeBook("Приключения", "Словарь", "Энциклопедия");
        reader1.takeBook(new Book("Приключения", "Автор1"), new Book("Словарь", "Автор2"), new Book("Энциклопедия", "Автор3"));

        System.out.println();

        reader2.returnBook(2);
        reader2.returnBook("Роман", "Детектив");
        reader2.returnBook(new Book("Роман", "Автор4"), new Book("Детектив", "Автор5"));
    }
}