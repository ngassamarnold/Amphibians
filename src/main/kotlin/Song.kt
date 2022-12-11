

class Song constructor(private val title:String, private val artist:String, private val yearPublished:Int, private val playCount:Int) {

    val isPopular: Boolean get() = playCount>=1000
    fun printDescription (): Unit {
        println("$title, interprété par $artist , est sorti en $yearPublished")
    }
}

//or
class Song_ constructor(private val title:String, private val artist:String, private val yearPublished:Int) {
       var type:String=""
         constructor(title:String,artist:String, playCount:Int,yearPublished:Int) : this(title,artist,yearPublished) {
              type= when(playCount){
                     in 0..100-> "Unpopular"
                     else-> "Popular"
              }
       }

       fun printDescription (): Unit{
              println("$title, interprété par $artist , est sorti en $yearPublished et est $type")
       }
}