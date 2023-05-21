
// 3.В городе N есть большой склад на котором существует 50000 различных полок.
// Для удобства работников руководство склада решило заказать для каждой полки
// табличку с номером от 00001 до 50000 в местной типографии, но когда таблички
// напечатали, оказалось что печатный станок из-за неисправности не печатал цифру 2,
// поэтому все таблички, в номерах которых содержалась одна или более двойка (например,
// 00002 или 20202) — надо перепечатывать. Напишите программу, которая подсчитает сколько
// всего таких ошибочных табличек оказалось в бракованной партии.

public class TaskThree {
    public static void main(String[] args) {
        int totalDefective = 0;

        for (int i = 1; i <= 50000; i++) {
            String number = String.valueOf(i);
            if (number.contains("2")) {
                totalDefective++;
            }
        }

        System.out.println("Number of errors: " + totalDefective);
    }
}