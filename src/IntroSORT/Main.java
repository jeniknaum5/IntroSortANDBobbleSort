package IntroSORT;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static void space(){
        System.out.println();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner option= new Scanner(System.in);

        System.out.println("Введите номер опции:");
        System.out.println("1)Случайные числа");
        System.out.println("2)Числа, отсортерованные в обратном порядке");
        System.out.println("3)Константные числа");
        System.out.println("4)Отсортированные числа");
        System.out.print("___ОПЦИЯ___:");
        String opt = option.nextLine();
        switch(opt){
            case "1":
                Scanner secondOption_1 = new Scanner(System.in);
                System.out.println("Выберите кол-во входных данных: ");
                System.out.println("1)100");
                System.out.println("2)1000");
                System.out.println("3)10000");
                System.out.print("Ваш выбор: ");
                String secOpt_1= secondOption_1.nextLine();
                Scanner file_rand = null;
                switch (secOpt_1){
                    case "1":
                        file_rand = new Scanner(new File("D:\\Projects\\LABS\\Lab2\\src\\Data\\random100.txt"));
                        break;
                    case "2":
                        file_rand = new Scanner(new File("D:\\Projects\\LABS\\Lab2\\src\\Data\\random1000.txt"));
                        break;
                    case "3":
                        file_rand = new Scanner(new File("D:\\Projects\\LABS\\Lab2\\src\\Data\\random10000.txt"));
                        break;
                    default:
                        System.out.println("ERROR: Выбрана неверная опция");
                }
                //Считываем файл

                //создаем лист под числа
                ArrayList<Integer> listRandom = new ArrayList<Integer>();
                //цикл с проверкой на наличие следующего символа в файле
                while(file_rand.hasNextLine()){
                    //запись строки в переменную
                    String line= file_rand.nextLine();

                    Scanner sc= new Scanner(line).useDelimiter(",");
                    //Добавление числа в лист
                    while(sc.hasNextInt()){
                        listRandom.add(sc.nextInt());
                    }
                    sc.close();
                }

                space();

                Integer[] arrRandom = listRandom.toArray(new Integer[listRandom.size()]);
                int nRand = arrRandom.length;

                IntroSort introsortRandom = new IntroSort(nRand);

                for (int i = 0; i < nRand; i++) {
                    introsortRandom.dataAppend(arrRandom[i]);
                }
                introsortRandom.printData();

                file_rand.close();
                //сортировка
                long start1 = System.currentTimeMillis();
                introsortRandom.sortData();
                long finish1 = System.currentTimeMillis();
                long time1 = (finish1 - start1);
                space();
                introsortRandom.printData();
                space();
                System.out.println("Копирований= ["+GlobalItems.COPY+"]");
                System.out.println("Проверок= ["+GlobalItems.COMPAR+"]");
                System.out.println("Время=["+time1+"]");
                break;
            case "2":
                Scanner secondOption_2 = new Scanner(System.in);
                System.out.println("Выберите кол-во входных данных: ");
                System.out.println("1)100");
                System.out.println("2)1000");
                System.out.println("3)10000");
                System.out.print("Ваш выбор: ");
                String secOpt_2= secondOption_2.nextLine();
                Scanner file_inverse = null;
                switch (secOpt_2){
                    case "1":
                        file_inverse = new Scanner(new File("C:\\Projects\\LABS\\Lab2\\src\\Data\\reversed100.txt"));
                        break;
                    case "2":
                        file_inverse = new Scanner(new File("C:\\Projects\\LABS\\Lab2\\src\\Data\\reversed1000.txt"));
                        break;
                    case "3":
                        file_inverse = new Scanner(new File("C:\\Projects\\LABS\\Lab2\\src\\Data\\reversed10000.txt"));
                        break;
                    default:
                        System.out.println("ERROR: Выбрана неверная опция");
                }
                //Считываем файл

                //создаем лист под числа
                ArrayList<Integer> listInverse = new ArrayList<Integer>();
                //цикл с проверкой на наличие следующего символа в файле
                while(file_inverse.hasNextLine()){
                    //запись строки в переменную
                    String line= file_inverse.nextLine();

                    Scanner sc= new Scanner(line).useDelimiter(",");
                    //Добавление числа в лист
                    while(sc.hasNextInt()){
                        listInverse.add(sc.nextInt());
                    }
                    sc.close();
                    //System.out.print(listRandom);
                }
                //создание и вывод массива с даными числами
                space();
                Integer[] arrInverse = listInverse.toArray(new Integer[listInverse.size()]);

                int nInverse = arrInverse.length;

                IntroSort introsortInverse = new IntroSort(nInverse);

                for (int i = 0; i < nInverse; i++) {
                    introsortInverse.dataAppend(arrInverse[i]);
                }

                introsortInverse.printData();
                file_inverse.close();
                long start2 = System.currentTimeMillis();
                introsortInverse.sortData();
                long finish2 = System.currentTimeMillis();
                long time2 = (finish2 - start2);
                space();
                introsortInverse.printData();
                space();


                System.out.println("Копирований= ["+GlobalItems.COPY+"]");
                System.out.println("Проверок= ["+GlobalItems.COMPAR+"]");
                System.out.println("Время=["+time2+"]");
                break;
            case "3":
                Scanner secondOption_3 = new Scanner(System.in);
                System.out.println("Выберите кол-во входных данных: ");
                System.out.println("1)100");
                System.out.println("2)1000");
                System.out.println("3)10000");
                System.out.print("Ваш выбор: ");
                String secOpt_3= secondOption_3.nextLine();
                Scanner file_constant = null;
                switch (secOpt_3){
                    case "1":
                        file_constant = new Scanner(new File("D:\\Projects\\LABS\\Lab2\\src\\Data\\constant100.txt"));
                        break;
                    case "2":
                        file_constant = new Scanner(new File("D:\\Projects\\LABS\\Lab2\\src\\Data\\constant1000.txt"));
                        break;
                    case "3":
                        file_constant = new Scanner(new File("D:\\Projects\\LABS\\Lab2\\src\\Data\\constant10000.txt"));
                        break;
                    default:
                        System.out.println("ERROR: Выбрана неверная опция");
                }
                //Считываем файл

                //создаем лист под числа
                ArrayList<Integer> listConstant = new ArrayList<Integer>();
                //цикл с проверкой на наличие следующего символа в файле
                while(file_constant.hasNextLine()){
                    //запись строки в переменную
                    String line= file_constant.nextLine();

                    Scanner sc= new Scanner(line).useDelimiter(",");
                    //Добавление числа в лист
                    while(sc.hasNextInt()){
                        listConstant.add(sc.nextInt());
                    }
                    sc.close();
                    //System.out.print(listRandom);
                }
                //создание и вывод массива с даными числами
                space();
                Integer[] arrConstant = listConstant.toArray(new Integer[listConstant.size()]);
                int nConstant = arrConstant.length;

                IntroSort introsortConstant = new IntroSort(nConstant);
                long start3 = System.currentTimeMillis();
                for (int i = 0; i < nConstant; i++) {
                    introsortConstant.dataAppend(arrConstant[i]);
                }

                introsortConstant.printData();
                file_constant.close();
                introsortConstant.sortData();
                long finish3 = System.currentTimeMillis();
                long time3 = (finish3 - start3);
                space();
                introsortConstant.printData();
                space();
                System.out.println("Копирований= ["+GlobalItems.COPY+"]");
                System.out.println("Проверок= ["+GlobalItems.COMPAR+"]");
                System.out.println("Время=["+time3+"]");
                break;
            case "4":
                Scanner secondOption_4 = new Scanner(System.in);
                System.out.println("Выберите кол-во входных данных: ");
                System.out.println("1)100");
                System.out.println("2)1000");
                System.out.println("3)10000");
                System.out.print("Ваш выбор: ");
                String secOpt_4= secondOption_4.nextLine();
                Scanner file_sorted = null;
                switch (secOpt_4){
                    case "1":
                        file_sorted = new Scanner(new File("D:\\Projects\\LABS\\Lab2\\src\\Data\\sorted100.txt"));
                        break;
                    case "2":
                        file_sorted = new Scanner(new File("D:\\Projects\\LABS\\Lab2\\src\\Data\\sorted1000.txt"));
                        break;
                    case "3":
                        file_sorted = new Scanner(new File("D:\\Projects\\LABS\\Lab2\\src\\Data\\sorted10000.txt"));
                        break;
                    default:
                        System.out.println("ERROR: Выбрана неверная опция");
                }
                //Считываем файл

                //создаем лист под числа
                ArrayList<Integer> listSorted = new ArrayList<Integer>();
                //цикл с проверкой на наличие следующего символа в файле
                while(file_sorted.hasNextLine()){
                    //запись строки в переменную
                    String line= file_sorted.nextLine();

                    Scanner sc= new Scanner(line).useDelimiter(",");
                    //Добавление числа в лист
                    while(sc.hasNextInt()){
                        listSorted.add(sc.nextInt());
                    }
                    sc.close();
                    //System.out.print(listRandom);
                }
                //создание и вывод массива с даными числами
                space();
                Integer[] arrSorted = listSorted.toArray(new Integer[listSorted.size()]);
                int nSorted = arrSorted.length;

                IntroSort introsortSorted = new IntroSort(nSorted);

                for (int i = 0; i < nSorted; i++) {
                    introsortSorted.dataAppend(arrSorted[i]);
                }

                introsortSorted.printData();
                file_sorted.close();
                long start4 = System.currentTimeMillis();
                introsortSorted.sortData();
                long finish4 = System.currentTimeMillis();
                long time4 = (finish4 - start4);
                space();
                introsortSorted.printData();
                space();
                System.out.println("Копирований= ["+GlobalItems.COPY+"]");
                System.out.println("Проверок= ["+GlobalItems.COMPAR+"]");
                System.out.println("Время=["+time4+"]");
                break;
            default:
                System.out.println("ОШИБКА: \"Неверная опция\"");
                break;
        }
    }
}
