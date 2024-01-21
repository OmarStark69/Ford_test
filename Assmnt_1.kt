fun int_to_rom(num: String){
    val letters = arrayOf("I", "V", "X", "L", "C", "D", "M") // array of roman symbols
    val max = 4*Math.pow(10.toDouble(),(letters.size/2).toDouble()).toInt() // max value of roman number
    print("${num}\t---->\t")
    val num = num.reversed()    // reverse number to start with the units
    val roman = StringBuilder()
    for (i in num.indices) {    // for each digit
        var mod4 = (num[i].digitToInt()%5) % 4 // is a 1,2 or 3?
        roman.insert(0,letters[2*i].repeat(mod4))   // add 1,2 or 3 symbols
        if ((2*i+1)<letters.size){  // if it is not the last number represented by the max roman symbol
            roman.insert(0,letters[2*i].plus(letters[2*i+1]).repeat(div4))  // add "4" symbols
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