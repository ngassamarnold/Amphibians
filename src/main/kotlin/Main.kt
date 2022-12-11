
fun main(args: Array<String>) {

    val treatFunction=trickOrTreat(false) { "$it quarters" }
    /*
    *or
    * val treatFunction=trickOrTreat(false,{"$it quarters"})
    *or
    * val treatFunction=trickOrTreat(false,coins)
     */
    val trickFunction=trickOrTreat(true,null)
    // treatFunction()
    repeat(4) {
        treatFunction()
    }

    trickFunction()
    /*val callIot = ::callIotAtHome
    callIot()
     */

    //EXO
    /*
    *Tiket cinema
    *
     */
    println("EXO")

    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true
    println()
    println("Tiket cinema")
    println("The movie ticket price for a person aged $child is  \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")

   /*
    *Convertisseur de
    *temperature
    * Degrés Celsius à Fahrenheit : ° F = 9/5 (° C) + 32
    *Kelvin à Celsius : ° = K - 273,15
    *Degrés Fahrenheit à kelvin : K = 5/9 (°F - 32) + 273,15
   */
    println()
    println("Convertisseur de temperature")
    printFinalTemperature(27.0,"Celsius","Fahrenheit") {(9.0 / 5.0 * it) + 32 }
    printFinalTemperature(350.0,"Kelvin","Celsius") { kelvin -> kelvin - 273.15 }
    printFinalTemperature(10.0,"Fahrenheit","Kelvin"){fahrenheit-> 5.0/9.0*(fahrenheit-32)+273.15 }
}

val coins:(Int)-> String ={
    "$it quarters"
}
/*
or
val coins:(Int)->String ={quantity->
    "$quantity quarters"
}
 */

val cupcake:(Int)->String ={
    "$it Have a cupcake!"
}
fun trickOrTreat(isTrick:Boolean, extraTreat:((Int)->String)?): ()->Unit {
    if(isTrick) {
        return trick
    }
    else {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        return treat
    }
}

val trick = {
    println("No treats!")
}

val treat:()-> Unit = {
    println("Have a treat!")
}
fun callIotAtHome(){
    val smartHome = SmartHome(
        SmartTvDevice(deviceName = "Android TV", deviceCategory = "Entertainment"),
        SmartLightDevice(deviceName = "Google light", deviceCategory = "Utility")
    )

    println("================= Light ======================")
    smartHome.decreaseLightBrightness()
    smartHome.printSmartLightInfo()
    smartHome.increaseLightBrightness()
    smartHome.turnOnLight()
    println("================= Light ======================")

    println()

    println("================= TV ======================")
    smartHome.printSmartTvInfo()
    smartHome.turnOnTv()
    smartHome.increaseTvVolume()
    smartHome.decreaseTvVolume()
    smartHome.changeTvChannelToNext()
    smartHome.changeTvChannelToPrevious()
    println("================= TV ======================")

    println()

    println("================= HOME ======================")
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}")
    smartHome.turnOffAllDevices()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}.")
    println("================= HOME ======================")
}

fun ticketPrice(age: Int, isMonday: Boolean): Int {
    // Fill in the code.
    return when(age){
        in 2..12 -> 15
        in 13..60-> if(isMonday)25 else 30
        in 61..100-> 20
        else -> -1
    }
}

fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}
