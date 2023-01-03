# String Builder methods and time complexity

StringBuffer is thread synchronized and thread safe


| Function     | Name   | Notes                                                                                                                                                            |
|--------------|--------|------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| reverse      | O(n)   ||
| toString     | O(n)   | toString() method is implemented using System.arrayCopy, which happens to be a native method                                                                     |
| substring    | O(n)   |                                                                                                                                                                  |
| indexOf      | O(m*n) | where n and m are the length of the search string and pattern respectively.                                                                                      |
| charAt       | O(1)   |                                                                                                                                                                  |
| deleteCharAt | O(N)   | cause if a random character is deleted, it ll shift the characters by that 1 space and the best case scenario is deleteing the last character that would be O(1) |
| equals       | O(N)   | same object O(1). different length strings O(1). same length strings O(N)                                                                                        |



