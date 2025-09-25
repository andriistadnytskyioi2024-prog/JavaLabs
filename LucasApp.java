import java.util.Scanner;

/**
 * Клас LucasNumber представляє число Люка.
 */
class LucasNumber {
    private int n;
    private long value;

    /**
     * Створює об'єкт з номером числа Люка та обчислює його значення.
     *
     * @param n номер числа Люка (>=0)
     */
    public LucasNumber(int n) {
        this.n = n;
        this.value = calculateLucas(n);
    }

    /**
     * Повертає номер числа Люка.
     *
     * @return номер числа Люка
     */
    public int getN() {
        return n;
    }

    /**
     * Повертає значення числа Люка.
     *
     * @return значення числа Люка
     */
    public long getValue() {
        return value;
    }

    /**
     * Обчислює N-те число Люка.
     *
     * @param n номер числа Люка
     * @return значення N-го числа Люка
     */
    private long calculateLucas(int n) {
        if (n == 0) return 2;
        if (n == 1) return 1;
        long prevPrev = 2;
        long prev = 1;
        long current = 0;
        for (int i = 2; i <= n; i++) {
            current = prev + prevPrev;
            prevPrev = prev;
            prev = current;
        }
        return current;
    }
}

/**
 * Головний клас програми.
 */
public class LucasApp {

    /**
     * Точка входу в програму.
     * <p>
     * Запитує у користувача номери чисел Люка та виводить їх.
     * </p>
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введіть номер числа Люка (або -1 для виходу): ");
            int n;

            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
            } else {
                System.out.println("Будь ласка, введіть ціле число.");
                scanner.next();
                continue;
            }

            if (n == -1) break;
            if (n < 0) {
                System.out.println("Номер має бути >= 0 або -1 для виходу.");
                continue;
            }

            LucasNumber lucas = new LucasNumber(n);
            System.out.println("Номер числа Люка: " + lucas.getN());
            System.out.println("Значення числа Люка: " + lucas.getValue());
        }

        System.out.println("Програма завершена.");
        scanner.close();
    }
}
