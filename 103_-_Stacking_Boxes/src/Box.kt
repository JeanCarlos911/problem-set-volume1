class Box(val number: Int) {
    val numbers: MutableList<Int> = mutableListOf()

    var weight: Int

    init {
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