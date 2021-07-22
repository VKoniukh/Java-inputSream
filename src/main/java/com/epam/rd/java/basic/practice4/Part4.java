package com.epam.rd.java.basic.practice4;

import java.util.Iterator;

public class Part4 implements Iterable {

    public static void main(String[] args) {

    }

    @Override
    public Iterator iterator() {
        return null;
    }
}


//    Создайте класс, реализующий интерфейс java.lang.Iterable. Класс должен анализировать текстовый файл и возвращать
//    предложения. Метод 'iterator' данного класса должен возвращать объект iterator - экземпляр внутреннего класса.
//    Метод Iterator # remove должен вызвать исключение UnsupportedOperationException.
//    Нельзя использовать существующие реализации итераторов из классов контейнеров!
//    Примечание. Запишите регулярное выражение, которое «вырезает» предложения из текста,
//    а затем используйте объект Matcher при реализации методов интерфейса Iterator.