class SmartHome(
    val smartTvDevice : SmartTvDevice,
    val smartLightDevice:SmartLightDevice
) {

    var deviceTurnOnCount=0
        private set

    //Tv
    fun turnOnTv(){
        if(smartTvDevice.deviceStatus=="on"){
            deviceTurnOnCount++
            smartTvDevice.turnOn()
        }
    }

    fun turnOffTv(){
        if(smartTvDevice.deviceStatus=="on") {
            deviceTurnOnCount--
            smartTvDevice.turnOff()
        }
    }

    fun increaseTvVolume() {
        if(smartTvDevice.deviceStatus=="on") {
            smartTvDevice.increaseSpeakerVolume()
        }
    }

    fun decreaseTvVolume() {
        if(smartTvDevice.deviceStatus=="on") {
            smartTvDevice.decreaseVolume()
        }
    }

    fun changeTvChannelToNext() {
        if(smartTvDevice.deviceStatus=="on") {
            smartTvDevice.nextChannel()
        }
    }

    fun changeTvChannelToPrevious() {
        if(smartTvDevice.deviceStatus=="on") {
            smartTvDevice.previousChannel()
        }
    }

    fun printSmartTvInfo() {
        if(smartTvDevice.deviceStatus=="on") {
            smartTvDevice.printDeviceInfo()
        }
    }

    //Light
    fun turnOnLight() {
        if(smartLightDevice.deviceStatus=="on") {
            deviceTurnOnCount++
            smartLightDevice.turnOn()
        }
    }

    fun turnOffLight() {
        if(smartLightDevice.deviceStatus=="on") {
            deviceTurnOnCount--
            smartLightDevice.turnOff()
        }
    }

    fun increaseLightBrightness() {
        if(smartLightDevice.deviceStatus=="on") {
            smartLightDevice.increaseBrightness()
        }
    }

    fun decreaseLightBrightness() {
        if(smartLightDevice.deviceStatus=="on") {
            smartLightDevice.decreaseBrightness()
        }
    }

    fun printSmartLightInfo() {
        if(smartLightDevice.deviceStatus=="on") {
            smartLightDevice.printDeviceInfo()
        }
    }

    //All devices
    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}
