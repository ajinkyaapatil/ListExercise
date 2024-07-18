package org.example

fun main() {
    Car(2010)
    Car("2020")
}

class Car<T>(year: T){
    init {
        println(year)
    }
}