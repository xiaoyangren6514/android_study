package com.happy.kotlin.demo

/**
 * Created by zhonglongquan on 2017/12/3.
 */
open class Person(var name: String, var age: Int) {
    init {
        println("${this.javaClass.simpleName} created, name is $name,age is $age")
    }
}

class Student(name: String, age: Int) : Person(name, age) {}

var stu = Student("wangcai", 12)

/**
 * 类的声明包括
 *  类名
 *  类头  指定类型参数，主构造函数等
 *  类体  大括号里内容
 */
open class Anim {
    open fun eat() {

    }
}

class Dog() : Anim() {
    override fun eat() {

    }
}
