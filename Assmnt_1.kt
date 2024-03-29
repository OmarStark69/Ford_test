fun int_to_rom(num: String){
    val letters = arrayOf("I", "V", "X", "L", "C", "D", "M") // array of roman symbols
    val max = 4*Math.pow(10.toDouble(),(letters.size/2).toDouble()).toInt() // max value of roman number
    if (num.toInt() > max-1) { // if the number is greater than max value
        println("Number must be less than ${max}") // print error
        return} // exit function
    print("${num}\t---->\t")
    val num = num.reversed()    // reverse number to start with the units
    val roman = StringBuilder()
    for (i in num.indices) {    // for each digit
        var div9 = num[i].digitToInt() / 9 // is a 9?
        var div5 = (num[i].digitToInt()%9) / 5  // is a 5?
        var div4 = (num[i].digitToInt()%9%5) / 4 // is a 4?
        var mod4 = (num[i].digitToInt()%5) % 4 // is a 1,2 or 3?
        roman.insert(0,letters[2*i].repeat(mod4))   // add 1,2 or 3 symbols
        if ((2*i+1)<letters.size){  // if it is not the last number represented by the max roman symbol
            roman.insert(0,letters[2*i].plus(letters[2*i+1]).repeat(div4))  // add "4" symbols
            roman.insert(0,letters[2*i+1].repeat(div5)) // add "5" symbols
            roman.insert(0,letters[2*i].plus(letters[2*i+2]).repeat(div9))  // add "9" symbols
            }}
    println(roman)}

fun main() {
    var num = readLine()!!
    while (num!=""){
        int_to_rom(num)
        num = readLine()!!
    }
    // test cases
    // for (num in arrayOf("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15")){
    //     int_to_rom(num)
    // }
}