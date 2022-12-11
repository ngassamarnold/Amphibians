class FoldablePhone(var isFolded:Boolean=true) : Phone() {

    override fun switchOff() {
        if(isFolded){
        super.switchOff()
        }
    }

    override fun switchOn() {
        if(!isFolded){
            super.switchOn()
        }
    }

    fun fold(){
        isFolded=true
    }

    fun unFold(){
        isFolded=false
    }
}