/**
 * @param {string} s
 * @return {string[]}
 */
/**Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.

 Return a list of all possible strings we could create. Return the output in any order.



 Example 1:

 Input: s = "a1b2"
 Output: ["a1b2","a1B2","A1b2","A1B2"]
 Example 2:

 Input: s = "3z4"
 Output: ["3z4","3Z4"]
 * */

var lettercasePermutationLeetcode784 = function(s) {

    const output = new Set();
    const strLen = s.length;

    dfs(s.charAt(0), 0, '', s, output, strLen);
    return [...output];


};

var dfs = function (inputChar,index, prefix, inputStr, output, strLen) {
    //console.log(prefix);

    if (index === strLen) {
        output.add(prefix);
        return;
    }

    if (isDigit(inputChar)) {
        dfs(inputStr.charAt(index+1),index+1, prefix.concat(inputChar), inputStr, output, strLen);
    }

    if (!isDigit(inputChar)) {
        dfs(inputStr.charAt(index+1), index+1, prefix.concat(inputChar.toLowerCase()), inputStr, output, strLen);
        dfs(inputStr.charAt(index+1), index+1, prefix.concat(inputChar.toUpperCase()), inputStr, output, strLen);
    }

}
var isDigit = function(ipChar) {
    return ipChar && ipChar >= '0' && ipChar <= '9';
}


const result = lettercasePermutationLeetcode784("a1b2");
console.log(result);


const result1 = lettercasePermutationLeetcode784("a1b2c456");
console.log(result1);