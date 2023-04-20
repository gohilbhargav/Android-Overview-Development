Type - 1 : ListOf
  
fun main()
{
    //U can not change the list
    //Readonly List
   /* var sub = listOf("abc","pqr","mno",45,90,20.58,true)
    var sub1 = listOf<String>("abc","pqr","mno","xyz")
    var sub2 = listOf<Int>(30,40,60,75,80)
    println(sub)
    println(sub1)
    println(sub2)*/

    //U can change the list
    var sub3 = mutableListOf("abc","pqr","mno",45,90,20.58,true)
    sub3.remove(true)
    println(sub3)
    var sub4 = mutableListOf<String>("abc","pqr","mno","xyz")
    sub4.add("Bhargav")
    println(sub4)
    var sub5 = mutableListOf<Int>(30,40,60,75,80)
    sub5.set(0,100)
    println(sub5)
}          
 


Type - 2 : SetOf


fun main()
{
     //U can not change the list
     //Readonly List
     //avoid repeated value in list

   /*  var sub = setOf("abc","pqr","mno","abc","pqr",80,90,80)
     println(sub)
     var sub1 = setOf<String>("abc","pqr","mno","xyz","abc","pqr")
     println(sub1)
     var sub2 = setOf<Int>(30,40,60,75,80,30,40,60)
     println(sub2)*/

    //U can change the list
    var sub3 = mutableSetOf("abc","pqr","mno","abc","pqr",80,90,80)
    sub3.remove("pqr")
    println(sub3)
    var sub4 = mutableSetOf<String>("abc","pqr","mno","xyz","abc","pqr")
    sub4.add("Bhargav")
    println(sub4)
    var sub5 = mutableSetOf<Int>(30,40,60,75,80,30,40,60)
    println(sub5)
} 
 
 
Type - 3 : MapOf
    
fun main()
{
    //Map of Key-pair
    //Ucan take any value in key
    //key-value -key ? -value ?
    //U can repeat key again

    /*var obj = mapOf("a" to "abc", 1 to "xyz", 2 to 44, 3 to "pqr", 4 to "pqr")
    println(obj)
    for (item in obj.keys)
    {
        println(item)
    }
    for (i in obj.values)
    {
        println(i)
    }
    for (key in obj.keys)
    {
        println("$key => ${obj[key]}")
    }

    var obj1 = mapOf<Int,Int>(1 to 101, 2 to 202, 3 to 402, 4 to 502)
    println(obj1[2])
    var obj2 = mapOf<Int,String>(1 to "abc", 2 to "xyz", 3 to "pqr", 4 to "pqr" )
    println(obj2[2])*/

    //U can change the list key and value
    var obj3 = mutableMapOf("a" to "abc", 1 to "xyz", 2 to 44, 3 to "pqr", 4 to "pqr")
    obj3.put("a","Bhargav")
    obj3.remove(4)
    println(obj3)

}

