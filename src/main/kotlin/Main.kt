enum class AccountType(
    val value: String
) {
    DEBIT("Debit"),
    CREDIT("Credit"),
    CHECKING("Checking")
}
var accountBalance = (0..1000).random()
val money = (0..1000).random()

fun withdraw(amount: Int): Int {
    accountBalance -= amount
    return amount
}

fun debitWithdraw(amount: Int): Int {
    return if (accountBalance == 0) {
        println("Can't withdraw, no money on this account!")
        accountBalance
    } else if (amount > accountBalance) {
        println("Not enough money on this account! The checking balance is $accountBalance dollars.")
        0
    } else
        withdraw(amount)
}

fun creditDeposit(amount: Int): Int {
    return if (accountBalance == 0) {
        println("You don't need to deposit anything in order to pay off the account since it has already been paid off.")
        accountBalance
    } else if (accountBalance + amount > 0) {
        println("Deposit failed, you tried to pay off an amount greater than the credit balance. The current balance is $accountBalance dollars.")
        0
    } else if (amount == -accountBalance) {
        accountBalance = 0
        println("You have paid of this account!")
        amount
    } else {
        deposit(amount)
    }
}

fun deposit(amount: Int): Int {
    accountBalance += amount
    println("You successfully deposited $amount dollars. The current balance is $accountBalance dollars.")
    return amount
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
    println("The current balance is $accountBalance dollars.")
    println("The amount you transferred is $money dollars.")

    var output: Int = withdraw(money)
    println("The amount you withdrew is $output dollars.")

    output = debitWithdraw(money)
    println("The amount you withdrew is $output dollars.")

    output = deposit(money)
    println("The amount you deposited is $output dollars.")

    output = creditDeposit(money)
    println("The amount you deposited is $output dollars.")
}