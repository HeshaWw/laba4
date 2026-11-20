package com.lab3;

/**Класс, представляющий жесткий диск
 * Наследуетсяот класса Component
 */

public class Winchester extends Component 
{
    /**Объем жесткого диска */
    private int capacity;

    /**
     * Конструктор для создания объекта Winchester
     * @param name Название
     * @param price Цена
     * @param capacity Объем в ГБ
     */

    public Winchester(String name, double price, int capacity)
    {
        super(name, price);
        this.capacity=capacity;
    }
    /**Возвращает объем жесткого диска
     * @return Объем
     */
   

    public int getCapacity(){ return capacity;}

     /**
     * Возвращает строковое представление объекта
     * @return Строка с названием, объемом, ценой
     */

    @Override 
    public String toString(){return "Винчестер " + name + " (" + capacity + "ГБ)";}
}