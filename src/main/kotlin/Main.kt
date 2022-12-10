
fun main(args: Array<String>) {

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



