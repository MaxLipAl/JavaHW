package Seminars.HomeWork.JavaHW;
/*
Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет
ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map.
Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации
можно также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
 */

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop(Brand.Apple, Color.Black, 64, 256, Os.Ios);
        Laptop laptop2 = new Laptop(Brand.Lenovo, Color.Red, 128, 512, Os.Windows);
        Laptop laptop3 = new Laptop(Brand.Huawei, Color.White, 16, 1024, Os.Android);
        Laptop laptop4 = new Laptop(Brand.HP, Color.Black, 16, 512, Os.Windows);
        Laptop laptop5 = new Laptop(Brand.Huawei, Color.Gray, 256, 256, Os.Android);
        Laptop laptop6 = new Laptop(Brand.Lenovo, Color.Blue, 8, 256, Os.Windows);
        Laptop laptop7 = new Laptop(Brand.Samsung, Color.Black, 512, 512, Os.Windows);

        HashSet<Laptop> laptopSet = new HashSet<>(Arrays.asList(laptop1, laptop2,
                laptop3, laptop4, laptop5, laptop6, laptop7));

        System.out.println("Ноутбуки в наличии:");
        for (Laptop laptop : laptopSet) {
            System.out.println(laptop);
        }
        System.out.println();
        printFiltered(laptopSet, getFilter());

    }
    public static Map<Integer, String> getFilter() {
        Map<Integer, String> filterMap = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите цифру, соответствующую необходимому критерию:" +
                "\n1 - бренд\n2 - цвет\n3 - ОЗУ\n4 - HDD\n5 - ОС\n0 - выход");
        System.out.print(": ");
        int input = scan.nextInt();
        while (!(input == 1 || input == 2 || input == 3 || input == 4 || input == 5 || input == 0)) {
            System.out.println("Не верный ввод, введите еще раз.");
            System.out.println("Введите цифру, соответствующую необходимому критерию:" +
                    "\n1 - бренд\n2 - цвет\n3 - ОЗУ\n4 - HDD\n5 - ОС\n0 - выход");
            System.out.print(": ");
            input = scan.nextInt();
        }
        if (input == 1) {
            System.out.print("Введите название бренда: ");
            filterMap.put(input, scan.next());
        } else if (input == 2) {
            System.out.print("Введите цвет: ");
            filterMap.put(input, scan.next());
        } else if (input == 3) {
            System.out.print("Введите минимальное значение ОЗУ: ");
            filterMap.put(input, scan.next());
        }
        else if (input == 4) {
            System.out.print("Введите минимальное значение HDD: ");
            filterMap.put(input, scan.next());
        }
        else if (input == 5) {
            System.out.print("Введите ОС: ");
            filterMap.put(input, scan.next());
        }
        scan.close();
        return filterMap;
    }
    public static void printFiltered(HashSet<Laptop> laptopSet, Map<Integer, String> filterMap) {
        for (Map.Entry<Integer, String> entry : filterMap.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            switch (key) {
                case 1:
                    for (Laptop laptop : laptopSet) {
                        if (laptop.brand.toString().equalsIgnoreCase(value))
                            System.out.println(laptop);
                    }
                    break;
                case 2:
                    for (Laptop laptop : laptopSet) {
                        if (laptop.color.toString().equalsIgnoreCase(value))
                            System.out.println(laptop);
                    }
                    break;
                case 3:
                    for (Laptop laptop : laptopSet) {
                        if (laptop.ram >= Integer.parseInt(value))
                            System.out.println(laptop);
                    }
                    break;
                case 4:
                    for (Laptop laptop : laptopSet) {
                        if (laptop.hdd >= Integer.parseInt(value))
                            System.out.println(laptop);
                    }
                    break;
                case 5:
                    for (Laptop laptop : laptopSet) {
                        if (laptop.os.toString().equalsIgnoreCase(value))
                            System.out.println(laptop);
                    }
                    break;
                default:
                    System.out.println("Ошибка!");
                    break;
            }
        }
    }
}

