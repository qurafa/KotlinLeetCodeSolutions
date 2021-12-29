fun main(args: Array<String>) {

    //01//
    var nums : IntArray = intArrayOf(-1,-2,-3,-4,-5)
    println("01: ${twoSum(nums = nums, target = -8).joinToString(separator = ",")}")

    //02//
    //...

    //09//
    val x = 121
    println("09: $x, ${isPalindrome(x)}")

}

//01//
fun twoSum(nums: IntArray, target: Int): IntArray {
    var ans = IntArray(2)
    myloop@ for(a in 0..nums.lastIndex){
        for(b in a+1..nums.lastIndex){
            if(nums[a] + nums[b] == target){
                ans[0] = a
                ans[1] = b
                break@myloop
            }
        }
    }

    return ans
}

//02//
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var p1 = l1
    var p2 = l2
    var p1Val = p1?.`val` ?: 0
    var p2Val = p2?.`val` ?: 0
    var ans = ListNode((p1Val + p2Val)%10)
    var carry = (p1Val + p2Val)/10
    var pAns = ans

    while(p1?.next != null || p2?.next != null || carry != 0){
        p1 = p1?.next
        p2 = p2?.next

        p1Val = p1?.`val` ?: 0
        p2Val = p2?.`val` ?: 0
        pAns?.next = ListNode((p1Val + p2Val + carry)%10)
        pAns = pAns.next!!
        carry = (p1Val + p2Val + carry)/10
    }

    return ans
}

//09//
fun isPalindrome(x: Int): Boolean {
    //First Attempt, kotlin methods
    /*if(x < 0){
        return false
    }else{
        var s = x.toString()
        return s == s.reversed()
    }*/
    //Second Attempt, recursion(revise this)
    /*println(x)
    if(x < 0){
        return false
    }else if(x == 0 || x < 10){
        return true
    }else{
        val bot = x % 10
        var v = 1
        while(x % v != x){
            v *= 10
        }
        v /= 10
        val top = (x - (x % v)) / v
        val next = (x - (x - (x % v)) - bot)/10
        println("$top, $bot")
        return (top == bot) && isPalindrome(next)
    }*/
}