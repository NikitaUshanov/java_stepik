/*

Я Занимала 2!

Напишите программу, которая будет формировать очередь оформления заявок в МФЦ. Сначала водится число n -  количество запросов в вашей программе. Каждый из запросов будет иметь один следующих видов:

    "Добавить <ИМЯ>" - Добавить человека с именем ИМЯ в конец очереди. Вывести на экран фразу "<ИМЯ> в очереди"
    "Следующий!" - вызвали человека, следующего первым по очереди. При этом человек с именем ИМЯ уходит из очереди и на экране появляется строка вида "<ИМЯ> в обработке". 
    "<ИМЯ1> занимала/занимал за <ИМЯ2>" - человек с именем ИМЯ1 становится в очередь за человеком по имени ИМЯ2. Если этот человек сейчас находится в обработке, то ИМЯ1 становится в начало очереди. Если такого человека в очереди нет, то ИМЯ1 становится в конец списка, при этом в консоль выводится фраза "<ИМЯ1, не надо тут ля-ля>".
    "Посмотреть очередь" - на экран в консоль выводится вся очередь через пробел.
    "Стоит ли оно того? <ИМЯ>" - человек с именем ИМЯ смотрит на очередь, если в ней сейчас меньше 5 человек, то он становится в конец очереди, если нет - то уходит, а в консоли появляется надпись "Слабак!"

Помимо этого, если вызывают следующего человека, а в очереди никого нет, то вывести в консоль фразу "Отлично, попью чаёк!". Если очередь пуста, а её пытаются вывести на экран, то следует вывести "*прокатилось перекати-поле*"

Sample Input:

15
Добавить Игорь
Добавить Антон
Добавить Катя
Лиза занимала за Игорь
Посмотреть очередь
Стоит ли оно того? Вася
Следующий!
Следующий!
Валя занимала за Игорь
Следующий!
Следующий!
Посмотреть очередь
Следующий!
Следующий!
Следующий!

Sample Output:

Игорь в очереди
Антон в очереди
Катя в очереди
Игорь Лиза Антон Катя
Игорь в обработке
Лиза в обработке
Валя, не надо тут ля-ля
Антон в обработке
Катя в обработке
Вася Валя
Вася в обработке
Валя в обработке
Отлично, попью чаёк!

*/

import java.util.ArrayList;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = "";
        String[] str1 = new String[5];
        String nameInProc = "";
        ArrayList<String> intList = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            str = sc.nextLine();
            str1 = str.split(" ");
            if (str1[0].equals("Добавить")) {
                intList.add(str1[1]);
                System.out.println(str1[1] + " в очереди");
            } else if (str1[0].equals("Следующий!")) {
                if (intList.size() > 0) {
                    nameInProc = intList.remove(0);
                    System.out.println(nameInProc + " в обработке");
                } else {
                    System.out.println("Отлично, попью чаёк!");
                }
            } else if (str1[1].equals("занимала") || str1[1].equals("занимал")) {
                if (nameInProc.equals(str1[3])) {
                    intList.add(0, str1[0]);
                } else if (intList.indexOf(str1[3]) == -1) {
                    intList.add(str1[0]);
                    System.out.println(str1[0] + ", не надо тут ля-ля");
                } else {
                    intList.add(intList.indexOf(str1[3])+1, str1[0]);
                }
            } else if (str.equals("Посмотреть очередь")) {
                if (intList.size() >= 1) {
                    String outList = "";
                    for (String itm : intList) {
                        outList = outList + itm + " ";
                    }
                    System.out.println(outList.trim());
                } else {
                    System.out.println("*прокатилось перекати-поле*");
                }
            } else if (str1[0].equals("Стоит")) {
                if (intList.size() < 5) {
                    intList.add(str1[4]);
                    //System.out.println(str1[4] + " добавлен");
                } else {
                    System.out.println("Слабак!");
                }
            }

        }

    }
}