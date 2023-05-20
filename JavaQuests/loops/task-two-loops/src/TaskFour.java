
//4.Электронные часы показывают время в формате от 00:00 до 23:59.
// Подсчитать сколько раз за сутки случается так, что слева от
// двоеточия показывается симметричная комбинация для той, что
// справа от двоеточия (например, 02:20, 11:11 или 15:51).

public class TaskFour {
    public static void main(String[] args) {
        int count = 0;

        for (int hours = 0; hours <= 23; hours++) {
            for (int minutes = 0; minutes <= 59; minutes++) {
                String hoursStr = String.format("%02d", hours);
                String minutesStr = String.format("%02d", minutes);

                if (hoursStr.charAt(0) == minutesStr.charAt(1) && hoursStr.charAt(1) == minutesStr.charAt(0)) {
                    count++;
                    System.out.println(hoursStr + ":" + minutesStr);
                }
            }
        }

        System.out.println("Number of mirrored: " + count);
    }
}
