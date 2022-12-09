import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

public class HW_Seminar_1 {

    /*Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя количество выполняемых действий к минимуму.
    входные данные находятся в файле input.txt в виде
    b 3
    a 10
    Результат нужно сохранить в файле output.txt
    1000 */
    static int inputNumber(String text1, String text2) {
        Scanner in = new Scanner(System.in);
        int number = 0;
        boolean check = true;
        while (check) {
            System.out.printf(text1);
            if (in.hasNextInt()) {
                number = in.nextInt();
                check = false;
            } else {
                System.out.println(text2);
                in.next();
            }
        }
        return number;
    }

    public static void main(String[] args) {
        var a = 1;
        var b = 3;
        int number;
        int degree;
        a = inputNumber("Введите целое число а: ", "Введите целое число, пожалуйста");
        b = inputNumber("Введите целое число b: ", "Введите целое число, пожалуйста");

        try (FileWriter fw = new FileWriter("input.txt", false)) {
            fw.write("a " + a);
            fw.append("\n");
            fw.write("b " + b);
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        String[] arr = new String[2];
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String str;
            while ((str = br.readLine()) != null) {
                arr[i] = str;
                i++;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        number = Integer.parseInt(arr[0].split(" ")[1].trim ());
        degree = Integer.parseInt(arr[1].split(" ")[1].trim ());
        var answer = Double.toString(Math.pow(number, degree));
        System.out.printf("a: %d\nb: %d\nanswer: %s", number, degree, answer);


        try (FileWriter fw = new FileWriter("output.txt", false)) {
            fw.write(answer);
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        }
    }

