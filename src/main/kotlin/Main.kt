fun main(args: Array<String>) {

    var smartDevice: SmartDevice = SmartTvDevice("Android tv","Entertainement")
    smartDevice.turnOn()
    smartDevice.turnOff()

    smartDevice=SmartLightDevice("Google Ligth","Utility")
    smartDevice.turnOn()
    smartDevice.turnOff()
    /*
    println("Device name is: ${smartTvDevice.name}")
   println("Device category is: ${smartTvDevice.category}")

   smartTvDevice.turnOn()
   smartTvDevice.turnOff()

  println("The volume is: ${smartTvDevice.speakerVolume}")
   smartTvDevice.speakerVolume=30
   println("The new volume is: ${smartTvDevice.speakerVolume}")
   println("Status smart tv is: ${smartTvDevice.deviceStatus}")
   */

}


open class SmartDevice protected constructor(val name: String, val category: String) {
    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        deviceStatus = when (statusCode) {
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
    }

    var deviceStatus = "online"
        protected set

    open val deviceType= "unknown"

    open fun turnOn(){
        deviceStatus="on"
    }

    open fun turnOff(){
        deviceStatus="off"
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {
    private var speakerVolume = 2
         set(value) {
            if (value in 0..100) {
                field = value
            }
        }
    private var channelNumber = 1
         set(value) {
            if (value in 0..200) {
                field = value
            }
        }
    override val deviceType= "Smart TV"

    override fun turnOn() {
        super.turnOn()
        deviceStatus = "on"
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                    "set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun decreaseSpeakerVolume() {
        speakerVolume--
        println("Speaker volume increased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    fun previousChannel() {
        channelNumber--
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    private var brightnessLevel = 0
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }
    override val deviceType= "Smart Ligth"

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    fun decreaseBrightness() {
        brightnessLevel--
        println("Brightness increased to $brightnessLevel.")
    }

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}

class SmartHome(
    val smartTvDevice : SmartTvDevice,
    val smartLightDevice:SmartLightDevice
    ) {

    var deviceTurnCount=0
    private set

    //Tv
    fun turnOnTv(){
        deviceTurnCount++
        smartTvDevice.turnOn()
    }

    fun turnOffTv(){
        deviceTurnCount--
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    //Light
    fun turnOnLight() {
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        smartLightDevice.turnOff()
    }

    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }

    //All devices
    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}
