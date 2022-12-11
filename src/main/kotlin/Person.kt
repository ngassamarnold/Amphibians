class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        println("Name: $name")
        println("Age: $age")
        println("Likes to climb: $hobby. ${yourReferrer(referrer)}")
    }
}

val yourReferrer:(person:Person?)->String={
    if (it==null){
        "Doesn't have a referrer."
    }else{
        var msg:String=""
        msg+= "Has a referrer named ${it.name}"
        if(it.hobby!=null) msg+=", who likes to play ${it.hobby}."
        msg
    }
}