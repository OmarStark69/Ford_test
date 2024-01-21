fun rom_to_dec(roman: String){
    var roman = roman // copy input
    print("${roman}\t---->\t") 
    val letters = arrayOf("I","V", "X", "L", "C", "D", "M") // array of roman symbols
    var num= 0 // initialize number
    var pos = letters.size -1 // initialize position of symbol with max value
    var last_pos = pos  // initialize last position of last "consumed" char in roman
    while (roman.length>0){
       if (letters[pos]==roman[0].toString().uppercase()) { // if the first char of roman is the current symbol
            num += Math.pow(10.toDouble(),((pos+1)/2).toDouble()).toInt()/(1+pos%2) // add value of symbol to number
            if (pos>last_pos){ // if the current symbol value is greater than the last one
               num-= Math.pow(10.toDouble(),((pos-1)/2).toDouble()).toInt()*2 // subtract the value of the last symbol twice
            }
            last_pos = pos // update last position
            roman = roman.drop(1) // remove first char of roman
       }else{pos--} // if the first char of roman is not the current symbol, try with the next one with less value
       if (pos==-1){pos = letters.size -1} // if the first char of roman is not any symbol, start again with the symbol with max value
    }
    println(num)
}

fun main() {
    var roman = readLine()!! // read input
    while (roman!=""){
        rom_to_dec(roman)
        roman = readLine()!!
    }

    // test cases
    // for (roman in arrayOf("I","II","III","IV","V","VI","VII","VIII","IX","X","XI","XII","XIII","XIV","XV")){
    //     rom_to_dec(roman)
    // }
}