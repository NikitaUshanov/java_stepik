/*

Замена 2

Вася из задачи на слайде 9 решил улучшить алгоритм. Что если у человека есть аллергия не на один, а на несколько продуктов? да и держать книгу как одну большую строку не очень удобно. Помимо всего прочего, непривычно видеть текст без заглавных букв.  Помогите Васе улучшить алгоритм.

Входные данные

На первой строке записывается натуральное число n - количество строчек в книге. Затем вводится n строк - строки книги. потом вводится натуральное число m - количество продуктов, на которые у человека аллергия. Потом вводится m строк - вида "продукт1 - продукт2", где продукт1 - продукт, на который у человека аллергия и продукт2 - продукт, на который следует заменить продукт1. Гарантируется что любой продукт состоит из 1 слова. название продуктов написаны строчными буквами. Гарантируется, что продукты, на которые нужно выполнить замену, не встречаются изначально в тексте.
Выходные данные

Замените все продукты в поваренной книге Васи и выведите их построчно на экран. На окончания не обращайте внимание. ВАЖНО!!! Если продукт, который следует заменить написан с большой буквы, то и замена тоже должна начинаться с большой буквы!

Sample Input:

2
Рецепт 1. Арахис 100гр, мороженое 200гр. Возьмите арахис и измелчите его. Посыпьте измельчённый арахис на мороженое.
Рецепт 2. Клубника 100гр, сгущенка 3кг. Смешать, есть) Радоваться жизни.
3
арахис - колбаса
клубника - вишня
сгущенка - молоко

Sample Output:

Рецепт 1. Колбаса 100гр, мороженое 200гр. Возьмите колбаса и измелчите его. Посыпьте измельчённый колбаса на мороженое.
Рецепт 2. Вишня 100гр, молоко 3кг. Смешать, есть) Радоваться жизни.

*/

import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] orig = new String[n];
        for (int i = 0; i < n; i++) {
            orig[i] = sc.nextLine();
        }

        int m = sc.nextInt();
        sc.nextLine();
        String strBuf = new String();
        String[][] repl = new String[m*2][2];
        for (int i = 0;i < m*2; i = i+2) {
            strBuf = sc.nextLine();
            String[] replBuf = strBuf.split(" - ");
            repl[i][0] = replBuf[0];
            repl[i][1] = replBuf[1];
            repl[i+1][0] = replBuf[0].substring(0,1).toUpperCase() + replBuf[0].substring(1,replBuf[0].length());
            repl[i+1][1] = replBuf[1].substring(0,1).toUpperCase() + replBuf[1].substring(1,replBuf[1].length());
        }
        String[] strOut = new String[n];
        for (int i = 0; i < n; i++) {
            strOut[i] = orig[i];
            for (int j = 0;j < repl.length;j++) {
                strOut[i] = strOut[i].replace(repl[j][0],repl[j][1]);
            }
            System.out.println(strOut[i]);
        }
    }
}