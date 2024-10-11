package pl.edu.wszib.car.rent;

import pl.edu.wszib.car.rent.core.Core;

/*
    To study:
    - Difference between ArrayList and LinkList (memory issue, references)
    - Hip, stack
    - Nadrzędny typ
    - Kotwica
    - Refaktoryzacja
    - SOLID
    - Interfejsy i klasy abstrakcyjne
    - Core i CarRepository tez interfejsy
    - Singleton
 */

public class App {
    public static void main(String[] args){
        Core.getInstance().run();
    }
}
