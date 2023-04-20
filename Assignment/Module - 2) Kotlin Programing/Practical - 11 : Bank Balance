fun main()
{
    var actualpin = 2806
    var openingbalance =5000
    var amt = 1500

    println("Enter Pin:---")
    var enteredpin = readLine()!!

    if(enteredpin.toInt() == actualpin)
    {
        println("Opening Balance : $openingbalance")
        println("=========================")
        println("Bank System Choice")
        println("1_____Credit")
        println("2_____Debit")
        println("=========================")

        println("Choice______")
        var Choice = readLine()!!

        if(Choice.toInt() == 1)
        {
            println("Your Final Balance is ${openingbalance + amt}")
        }
        else if(Choice.toInt() == 2)
        {
            println("Your Final Balance is ${openingbalance - amt}")
        }
        else
        {
            println("Invalid Choice")
        }
    }
    else
    {
        println("Invalid Pin")
    }
}

