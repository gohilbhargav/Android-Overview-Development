fun main()
{
    println("Enter preview reading : ")
    var preading = readLine()!!

    println("Enter current reading : ")
    var creading = readLine()!!

    if(creading.toInt() > preading.toInt())
    {
        var actualreading = creading.toInt() - preading.toInt()
        println("ActualReading is $actualreading")

        println("User Type____")
        var uType = readLine()!!
        if(uType == "v" || uType == "V")
        {
            println("Your Bill is ${actualreading * 2}")
        }
        else if(uType == "c" || uType == "C")
        {
            println("Your Bill is ${actualreading * 3}")
        }
        else if(uType == "i" || uType == "I")
        {
            println("Your Bill is ${actualreading * 5}")
        }
    }
    else
    {
        println("Invalid")
    }

}
