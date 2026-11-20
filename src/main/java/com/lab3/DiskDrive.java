package com.lab3;

/**
 * Класс для дисковода
 * Наследуется от класса Component
 */

public class DiskDrive extends Component 
{
    /**
     * Тип дисковода
     */
    private String type;

    /**
     * Конструктор для создания объекта DiskDrive
     * @param name Название производителя
     * @param price Цена
     * @param type Тип привода
     */

    public DiskDrive(String name, double price, String type)
    {
        super(name, price);
        this.type=type;
    }
    /**
     * Возврвщвет строковое представление объекта
     * @return Строка с названием и типом привода
     */

    @Override 
    public String toString(){return "Дисковод " + name + " (" + type + ")";}
}