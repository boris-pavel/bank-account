enum class AccountType(
    val value: String
) {
    DEBIT("Debit"),
    CREDIT("Credit"),
    CHECKING("Checking")
}


fun main() {
    println("Welcome to your banking system.")
    println("What type of account would you like to create?")
    println("1. Debit account")
    println("2. Credit account")
    println("3. Checking account")
    println("Choose an option (1, 2 or 3)")

    val userChoice = readln().toInt()
    val accountType = when (userChoice) {
        1 -> AccountType.DEBIT
        2 -> AccountType.CREDIT
        3 -> AccountType.CHECKING
        else -> {
            println("This is not a valid option!")
            return
        }
    }

    println("You have created a ${accountType.value} account.")
}