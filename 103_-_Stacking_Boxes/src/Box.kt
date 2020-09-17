class Box {
    val number: Int
    val numbers: MutableList<Int>

    var weight: Int

    constructor(number: Int) {
        this.number = number
        numbers = mutableListOf()
        weight = 0
    }

    fun calculateWeight() {
        weight = numbers.sum()
    }

    fun addNumber(number: Int) {
        numbers.add(number)
    }

    fun sort() {
        numbers.sort()
    }

}