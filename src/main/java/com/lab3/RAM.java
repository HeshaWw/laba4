package com.lab3;

/**
 * Класс, представляющий оперативную память
 * Наследуется от класса Component
 * RAM
 */
public class RAM extends Component
{
    /** Объем оперативной памяти */
    private int capacity;

    /**Конструктор для создания объекта RAM 
     * @param name Название модуля памяти
     * @param price Цена модуля
     * @param capacity Объем в ГБ
    */

    public RAM(String name, double price, int capacity)
    {
        super(name, price);
        this.capacity=capacity;
    }

    /** 
     * Возврвщвет строковое представление объекта
     * @return Строка с названием, объектом и ценой
     */

    @Override 
    public String toString() {return "ОЗУ " + name + " (" + capacity + " ГБ)";}
}