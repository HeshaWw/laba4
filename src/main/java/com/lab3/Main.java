package com.lab3;

import java.util.ArrayList;
import java.util.List;

/**
 * Главный класс приложения. Содержит точку входа (метод main)
 * Демонстрирует работу созданной иерархии классов
 */
public class Main {
    
    /**
     * Главный метод, с которого начинается выполнение программы
     */
    public static void main(String[] args) {
        List<Computer> computers = new ArrayList<>();

        // Массивы для генерации реалистичных характеристик
        int[] ramSizes = {8, 16, 16, 32, 32, 64, 8, 16, 32, 64};
        int[] diskSizes = {256, 512, 512, 1024, 2048, 4096, 256, 1024, 512, 2048};
        String[] ramBrands = {"Kingston", "HyperX", "Corsair", "Patriot"};
        String[] diskBrands = {"Seagate", "WD", "Samsung", "Toshiba"};
        String[] driveBrands = {"LG", "Asus", "Sony", "Pioneer"};
        String[] driveTypes = {"DVD-RW", "Blu-Ray", "CD-ROM", "DVD-ROM"};
        double[] drivePrices = {1200, 4500, 500, 900};

        // Создание 10 объектов Компьютер
        for (int i = 0; i < 10; i++) {
            boolean isCustom = ((i + 1) % 3 == 0); // Каждый 3-й - ручная сборка
            Computer pc = new Computer(isCustom);
            
            // Добавление ОЗУ
            int currentRam = ramSizes[i];
            String currentRamBrand = ramBrands[i % ramBrands.length];
            double ramPrice = 1000 + (currentRam * 100);
            pc.addComponent(new RAM(currentRamBrand, ramPrice, currentRam));
            
            // Добавление Винчестера
            int currentDisk = diskSizes[i];
            String currentDiskBrand = diskBrands[i % diskBrands.length];
            double diskPrice = 1500 + (currentDisk * 5);
            pc.addComponent(new Winchester(currentDiskBrand, diskPrice, currentDisk));
            
            // Добавление Дисковода (у каждого 4-го ПК его нет)
            if (i % 4 != 0) {
                String currentDriveBrand = driveBrands[i % driveBrands.length];
                String currentDriveType = driveTypes[i % driveTypes.length];
                double currentDrivePrice = drivePrices[i % drivePrices.length];
                pc.addComponent(new DiskDrive(currentDriveBrand, currentDrivePrice, currentDriveType));
            }
            
            computers.add(pc);
        }

        // 1. Вывод всей информации
        System.out.println("\n----- Вся информация о компьютерах -----");
        for (Computer pc : computers) {
            System.out.println(pc);
        }

        // 2. Вывод компьютеров ручной сборки
        System.out.println("\n----- Компьютеры ручной сборки -----");
        for (Computer pc : computers) {
            if (pc.isCustomBuilt()) {
                System.out.println(pc);
            }
        }

        // 3. Поиск самого выгодного компьютера
        Computer bestPc = computers.get(0);
        for (Computer pc : computers) {
            if (pc.getTotalPrice() < bestPc.getTotalPrice()) {
                bestPc = pc;
            }
        }
        System.out.println("\n----- Самый выгодный компьютер -----");
        System.out.println(bestPc);

        // 4. Демонстрация докупки компонентов
        System.out.println("\n----- Докупка компонентов -----");
        System.out.println("Докупаем дополнительный винчестер на 1 ТБ (1000 ГБ) для первого ПК...");
        computers.get(0).addComponent(new Winchester("WD Blue", 6500, 1000));
        System.out.println("Обновленный список комплектующих первого ПК:");
        System.out.println(computers.get(0).toString());

        // 5. Демонстрация работы методов (включение, проверка на вирусы, вывод размера винчестера, выключение)
        System.out.println("\n----- Демонстрация методов всех ПК -----");
        for (int i = 0; i < computers.size(); i++) {
            System.out.println("\n--- Проверка ПК №" + (i + 1) + " ---");
            computers.get(i).turnOn();
            computers.get(i).checkViruses();
            computers.get(i).printWinchesterSize();
            computers.get(i).turnOff();
        }
    }
}
//mvn clean compile exec:java
//chcp 65001
//java -cp target/classes com.lab3.Main