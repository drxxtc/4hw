import java.util.*
class LIFO<T>(var length: Int){
    var array = arrayOfNulls<Any>(length) as Array<T?>
    var pointer=length-1

    fun remove(): Any? { //возращает последний элемент, удаляет его
        if (array.isEmpty())
            throw EmptyStackException()
        val first=array[pointer]
        array[pointer--] = null
        return first
    }

    //возвращает последний элемент. Возвращает null, если стек пустой
    fun peek(): Any? {
        if (array.isEmpty())
            return null
        return array[pointer]
    }

    //возращает последний элемент, удаляет его. Если список пустой, то null
    fun poll(): T?{
        if (array.isEmpty())
            return null
        val first=array[pointer]
        array[pointer] = null
        return first as T
    }
    //добавляет эл-т в стек, возращает true
    fun offer(el: T?): Boolean{
        if (array.size == pointer)
            resize()
        array[pointer]=el
        return true
    }

    fun resize() {
        length += length / 2
        val newArray = arrayOfNulls<Any>(length) as Array<T?>
        System.arraycopy(array, 0, newArray, 0, length +1)
        array = newArray
    }
}