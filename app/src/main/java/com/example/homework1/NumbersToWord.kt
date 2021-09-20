package com.example.homework1

class NumbersToWord {

    private val listUnits = mapOf(
        1 to "ერთი", 2 to "ორი", 3 to "სამი",
        4 to "ოთხი", 5 to "ხუთი", 6 to "ექვსი",
        7 to "შვიდი", 8 to "რვა", 9 to "ცხრა",
        10 to "ათი", 11 to "თერთმეტი", 12 to "თორმეტი",
        13 to "ცამეტი", 14 to "თოთხმეტი", 15 to "თხუთმეტი",
        16 to "თექვსმეტი", 17 to "ჩვიდმეტი", 18 to "თვრამეტი",
        19 to "ცხრამეტი", 20 to "ოცდა", 30 to "ოცდა",
        40 to "ორმოცდა", 50 to "ორმოცდა", 60 to "სამოცდა",
        70 to "სამოცდა", 80 to "ოთხმოცდა", 90 to "ოთხმოცდა"
    )

    private val listTens = mapOf(
        20 to "ოცი", 30 to "ოცდაათი", 40 to "ორმოცი",
        50 to "ორმოცდაათი", 60 to "სამოცი", 70 to "სამოცდაათი",
        80 to "ოთხმოცი", 90 to "ოთხმოცდაათი", 100 to "ას",
        200 to "ორას", 300 to "სამას", 400 to "ოთხას", 500 to "ხუთას", 600 to "ექვსას",
        700 to "შვიდას", 800 to "რვაას", 900 to "ცხრაას", 1000 to "ათას"
    )

    private fun numUnder100(number: Int): String? {

        return when {
            listTens.containsKey(number) -> listTens[number]
            listUnits.containsKey(number) -> listUnits[number]
            else -> listUnits[number - number % 10] + listUnits[number % 20]
        }
    }

    private fun numOver100(number: Int) =
        if (listTens.containsKey(number)) listTens[number] + PLUS_LAST_LETTER else listTens[number - number % ONE_HUNDRED] + numUnder100(
            number % ONE_HUNDRED
        )

    fun numToWord(num: Int): String? {
        return when (num) {
            in 100..1000 -> {
                numOver100(num)
            }
            in 1..99 -> {
                numUnder100(num)
            }
            else -> {
                "Number Value is over 1000"
            }
        }
    }

    companion object {
        const val PLUS_LAST_LETTER = "ი"
        const val ONE_HUNDRED = 100
    }

}