/** 2. Add Two Numbers

 You are given two non-empty linked lists representing two non-negative integers.
 The digits are stored in reverse order, and each of their nodes contains a single digit.
 Add the two numbers and return the sum as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 Example 1:


 Input: l1 = [2,4,3], l2 = [5,6,4]
 Output: [7,0,8]
 Explanation: 342 + 465 = 807.
 Example 2:

 Input: l1 = [0], l2 = [0]
 Output: [0]
 Example 3:

 Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 Output: [8,9,9,9,0,0,0,1]

 * */

/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */

function ListNode(val, next) {
    this.val = (val===undefined ? 0 : val)
    this.next = (next===undefined ? null : next)
}

var addTwoNumbers = function(l1, l2) {

    var reminder = 0;
    var root; //{ListNode}
    var lastNode;
    while (l1?.val !== undefined || l2?.val !== undefined || reminder !== 0) {

        var totalValue = getValueOrZero(l1) + getValueOrZero(l2) + reminder;

        var lastDigit = totalValue % 10;

        if (totalValue <= 9) {
            reminder = 0;
        } else {
            reminder = 1;
        }


        if (root === undefined) {

            root = new ListNode(lastDigit, null);
            lastNode = root;

        } else {
            var newNode =  new ListNode(lastDigit, null);
            lastNode.next = newNode;
            lastNode = newNode;
        }
        l1 = l1?.next;
        l2 = l2?.next;

    }



    return root;




};

// param: linkedNode
function getValueOrZero(l) {
    if (l === null) {
        return 0;
    }
    return l?.val ? l.val : 0;
}

var l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
var l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));

addTwoNumbers(l1, l2);

