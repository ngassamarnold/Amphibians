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
