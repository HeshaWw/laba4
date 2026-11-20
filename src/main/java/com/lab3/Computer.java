package com.lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer 
{
    private List<Component> components = new ArrayList<>();
    private boolean isCustomBuilt;
    private List<String> files = new ArrayList<>();

    // "Безобидные" имена/расширения
    private static final String[] SAFE_NAMES  = {"document", "photo", "music", "report", "notes", "video", "archive"};
    private static final String[] SAFE_EXT    = {".txt", ".jpg", ".mp3", ".docx", ".pdf", ".png", ".mp4"};

    // "Подозрительные" имена/расширения
    private static final String[] VIRUS_NAMES = {"crack", "keygen", "install", "setup", "update", "free_money"};
    private static final String[] VIRUS_EXT   = {".exe", ".bat", ".scr", ".vbs", ".js"};

    public Computer(boolean isCustomBuilt)
    {
        this.isCustomBuilt = isCustomBuilt;
        generateRandomFiles();   // у каждого ПК свой набор
    }

    /** Генерирует 3–7 случайных файлов, ~30% из них — "заражённые" */
    private void generateRandomFiles()
    {
        Random rnd = new Random();
        int count = 3 + rnd.nextInt(5); // 3..7
        for (int i = 0; i < count; i++) {
            boolean suspicious = rnd.nextInt(100) < 30;
            if (suspicious) {
                files.add(VIRUS_NAMES[rnd.nextInt(VIRUS_NAMES.length)] + "_"
                        + (1 + rnd.nextInt(100))
                        + VIRUS_EXT[rnd.nextInt(VIRUS_EXT.length)]);
            } else {
                files.add(SAFE_NAMES[rnd.nextInt(SAFE_NAMES.length)] + "_"
                        + (1 + rnd.nextInt(100))
                        + SAFE_EXT[rnd.nextInt(SAFE_EXT.length)]);
            }
        }
    }

    /** Проверка "файлов" ПК на подозрительные расширения */
    public void checkViruses()
    {
        List<String> threats = new ArrayList<>();
        for (String f : files) {
            String lower = f.toLowerCase();
            for (String ext : VIRUS_EXT) {
                if (lower.endsWith(ext)) { threats.add(f); break; }
            }
        }

        System.out.println("Сканирование файлов ПК (" + files.size() + " шт.)...");
        if (threats.isEmpty()) {
            System.out.println("✔ Вирусов не обнаружено.");
        } else {
            System.out.println("⚠ Обнаружены подозрительные файлы (" + threats.size() + "):");
            for (String t : threats) System.out.println("   - " + t);
        }
    }

    // ----- остальное без изменений -----

    public void turnOn()  { System.out.println("ПК включен"); }
    public void turnOff() { System.out.println("ПК выключен"); }

    public void printWinchesterSize()
    {
        for (Component c : components) {
            if (c instanceof Winchester) {
                System.out.println("Размер винчестера: " + ((Winchester) c).getCapacity() + " ГБ");
                return;
            }
        }
        System.out.println("Винчестер не установлен");
    }

    public void addComponent(Component c) { components.add(c); }
    public boolean isCustomBuilt()        { return isCustomBuilt; }

    public double getTotalPrice()
    {
        double sum = 0;
        for (Component c : components) sum += c.getPrice();
        return sum;
    }

    @Override
    public String toString()
    {
        String type = isCustomBuilt ? "Ручная сборка" : "Заводская сборка";
        StringBuilder sb = new StringBuilder("--- " + type + " ---\n");
        for (Component c : components) sb.append("  * ").append(c).append("\n");
        sb.append("Общая стоимость: ").append(getTotalPrice()).append(" руб\n");
        return sb.toString();
    }
}