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

//04//
fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {

    if(nums1.size == 0 && nums2.size >= 1){
        val mid = nums2.size/2
        return if(nums2.size%2 == 0){(nums2[mid-1] + nums2[mid])/2.0} else {nums2[mid]/1.0}
    }
    else if(nums1.size >= 1 && nums2.size == 0){
        val mid = nums1.size/2
        return if(nums1.size%2 == 0){(nums1[mid-1] + nums1[mid])/2.0} else {nums1[mid]/1.0}
    }
    else if(nums1.size == 1 && nums2.size == 1){
        return (nums1[0] + nums2[0])/2.0
    }
    else{
        var nums1Temp = nums1.copyOf(nums1.size)
        var nums2Temp = nums2.copyOf(nums2.size)
        val dropFirstNum1 : Boolean = nums1Temp[0] <= nums2Temp[0]
        val dropLastNum1 : Boolean = nums1Temp[nums1Temp.lastIndex] >= nums2Temp[nums2Temp.lastIndex]

        if(dropFirstNum1){
            nums1Temp = nums1Temp.drop(1).toIntArray()
        }
        else{
            nums2Temp = nums2Temp.drop(1).toIntArray()
        }

        if(dropLastNum1){
            nums1Temp = nums1Temp.dropLast(1).toIntArray()
        }
        else{
            nums2Temp = nums2Temp.dropLast(1).toIntArray()
        }

        return findMedianSortedArrays(nums1Temp, nums2Temp)
    }
}

//09//
fun isPalindrome(x: Int): Boolean {
    //First Attempt, kotlin methods
    if(x < 0){
        return false
    }else{
        return x.toString() == x.toString().reversed()
    }
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