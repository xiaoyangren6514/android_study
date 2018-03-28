package com.happy.kotlin.demo

/**
 * Created by zhonglongquan on 2017/11/29.
 */

/**
 * 定义一个函数
 *  两个int型参数，返回值为int
 */
fun sum(a: Int, b: Int): Int {
    return a + b
}

fun main(args: Array<String>) {
    println("hello world")
    println("3 + 5 = " + sum(3, 1))
    println("sum1 of 19 and 22 is ${sum1(19, 22)}")
    // 声明常量  不可变
    val a: Int = 1 // 立即初始化
    val b = 2 //推导出int型
    val c: Int //当没有初始值时必须声明类型
    c = 3 // 赋值
    // 声明变量
    var x = 5
    x += 1
    println("x = $x")
    // 使用字符串模板
    var m = 1
    val s = "a is $m"
    m = 3
    // 使用表达式作为模板
    val s2 = "${s.replace("is", "was")},but now is $m"
    println(s2)
    printProduct("12", "s")
    // 使用循环
    val items = listOf("apple", "banana", "kiwi")
    for (index in items.indices) {
        println(items.get(index))
    }
    // 使用while
    var index = 0
    while (index < items.size) {
        println("item at $index valus is ${items[index]}")
        index++
    }
    // 使用when
    println(desc("1"))
    println(desc("hello"))
    println(desc(12))
    // 使用in操作符检查数值是否在某个范围内
    inTest()
    notInTest()
    inTest2()
    inTest3()
    iterColl()
    lambdaTest()
}

/**
 * 该函数只有一个表达式函数体以及一个自推导型的返回值
 */
fun sum1(a: Int, b: Int) = a + b

/**
 * 类Java中void返回
 */
fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

/**
 * 使用条件表达式
 */
fun maxOf(x: Int, y: Int): Int {
    if (x >= y) {
        return x
    } else {
        return y
    }
}

fun maxOf2(x: Int, y: Int) {
    if (x > y) x else y
}

fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printProduct(arg1: String, arg2: String) {
    var x = parseInt(arg1)
    var y = parseInt(arg2)
    if (x != null && y != null) {
        println("$x * $y is ${x * y}")
    } else {
        println("either '$arg1' or '$arg2' is not a number")
    }
}

/**
 * 使用值检查并自动转换
 *  使用is操作符检查一个表达式是否是某个类型的实例。
 *  如果对不可变的局部变量或属性进行过了类型检查，就没有必要明确转换
 */

fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // 此处分支自动转换为string
        return obj.length
    }
    return null
}

/**
 * when处理
 */
fun desc(obj: Any): String =
        when (obj) {
            1 -> "one"
            "hello" -> " world"
            is Long -> "Long"
            !is String -> "not a string"
            else -> "unkonw"
        }

/**
 * 使用in操作符检查数值是否在某个范围内
 */
fun inTest() {
    val x = 10
    val y = 9
    if (x in 1..y + 1) {
        println("fits in range")
    }
}

fun notInTest() {
    val list = listOf("a", "v", "f")
    println("0..list.lastIndex is ${0..list.lastIndex}")
    if (1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    } else {
        println(" in range")
    }
    println("list.indices is ${list.indices}")
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range too")
    }
}

fun inTest2() {
    for (x in 1..5) {
        print(x)
    }
}

/**
 * 使用步进
 */
fun inTest3() {
    for (x in 1..10 step 3) {
        print(x)
    }
    println("**")
    for (x in 9 downTo 2 step 3) {
        print(x)
    }
}

/**
 * 使用in操作符检查集合中是否包含某个对象
 */
fun iterColl() {
    val items = setOf("apple", "banana")
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }
}

/**
 * 使用lambda表达式过滤和映射集合
 */
fun lambdaTest() {
    val fruits = listOf("banana", "apple", "wikr")
    fruits.filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
}