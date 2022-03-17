class FIFO<T>(private var length: Int){
    private var array = arrayOfNulls<Any>(length) as Array<T?>
    private var pointer=0

    fun element(): Any?{ //возращает первый элемент, не удаляя его
        if (array.isEmpty())
            throw NoSuchElementException("Queue is empty")
        return (array[0])
    }
    fun remove(): Any? { //удаляет элемент из головы очереди, возвращая его
        if (array.isEmpty())
            throw NoSuchElementException("Queue is empty")
        val first=array[0]
        System.arraycopy(array, 1, array, 0, length - 1)
        return first
    }

   //возвращает элемент из головы очереди. Возвращает null, если очередь пуста. Элемент не удаляется.
    fun peek(): Any?{
        if (array.isEmpty())
            return null
        return array[0]
    }

    //возвращает элемент из головы очереди и удаляет его. Возвращает null, если очередь пуста.
    fun poll(): Any?{
        if (array.isEmpty())
            return null
        val first=array[0]
        System.arraycopy(array, 1, array, 0, length - 1)
        return first
    }

    //пытается добавить оbj в очередь. Возвращает true, если оbj добавлен, и false в противном случае.
    fun offer(el: T?): Boolean{
        if (array.size == pointer)
            resize()
        array[pointer]=el
        pointer++
        return true
    }

    fun resize() {
        length += length / 2
        val newArray = arrayOfNulls<Any>(length) as Array<T?>
        System.arraycopy(array, 0, newArray, 0, length +1)
        array = newArray
    }
}