package com.lab3;
/**
 * Базовый абстрактный класс,представляющий комплектующее изделие
 * Родительский класс для все компонентов компьютера
 */
public abstract class Component {
    /**Наименование комплектующего*/
    protected String name;
    /**Стоимость комплектующего в рублях */
    protected double price;

    /**Конструктор базового класса комплектующего
     * @param name Название компонента
     * @param price Цена компонента
     */

    public Component(String name, double price)
    {
        this.name=name;
        this.price=price;
    }

    /**
     * Возвращает соимость комплектующего
     * @return Цена в рублях
     */
    public double getPrice() {return price;}
}