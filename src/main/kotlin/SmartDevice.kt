open class SmartDevice protected constructor(val name: String, val category: String) {
    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        deviceStatus = when (statusCode) {
            0 -> "off"
            1 -> "on"
            else -> "unknown"
        }
    }

    var deviceStatus = "on"
        protected set

    open val deviceType= "unknown"

    open fun turnOn(){
        deviceStatus="on"
    }

    open fun turnOff(){
        deviceStatus="off"
    }

    fun printDeviceInfo(){
        println("Device name: $name, category: $category, type: $deviceType")
    }
}
