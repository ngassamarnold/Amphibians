class Bid(val amount: Int, val bidder: String)

val auctionPrice:(bid: Bid?, minimumPrice: Int)->Int= {bid,min->
    bid?.amount ?: min
}