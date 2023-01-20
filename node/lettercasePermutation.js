/**
 * @param {string} s
 * @return {string[]}
 */
var letterCasePermutation = function(s) {

    const output = new Set();
    const strLen = s.length;

    const dfsStart = false;
    var prefix = '';

    for(const element of s) {


            console.log("dfs ", element, prefix, s, output, strLen);

            dfs(element, prefix, s, output, strLen);



    }
    return [...output];


};

var dfs = function (inputChar, prefix, inputStr, output, strLen) {
    if (prefix.length === strLen) {
        output.add(inputStr);
        return;
    }

    if (isDigit(inputChar)) {
        dfs(inputStr.charAt(prefix.length), prefix + inputChar, inputStr, output, strLen);
    }
    if (!isDigit(inputChar)) {
        console.log("in dfs ", inputStr.charAt(prefix.length-1), prefix + inputChar.toLowerCase(), inputStr, output, strLen);
        dfs(inputStr.charAt(prefix.length), prefix + inputChar.toLowerCase(), inputStr, output, strLen);
        console.log("in dfs ", inputStr.charAt(prefix.length-1), prefix + inputChar.toUpperCase(), inputStr, output, strLen);
        dfs(inputStr.charAt(prefix.length), prefix + inputChar.toUpperCase(), inputStr, output, strLen);
    }



}
var isDigit = function(ipChar) {
    return ipChar >= '0' && ipChar <= '9';
}


const result = letterCasePermutation("a1b2");
console.log(result);