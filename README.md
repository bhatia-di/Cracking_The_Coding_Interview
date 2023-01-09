# **Cracking the Coding Interview with Leetcode, important patterns for Interview**

## Reversing, Sorting A List
```
    List<String> colors = new ArrayList<>(Arrays.asList("RED", "BLUE", "BLACK"));
    Collections.reverse(colors);
    Collections.sort(colors);
```

## Binary Search on a sorted List
        
```
int binarySearch(int arr[], int l, int r, int x)
        {
            if (r >= l) {
                int mid = l + (r - l) / 2;        
                    if (arr[mid] == x)
                        return mid;         
                    if (arr[mid] > x)
                        return binarySearch(arr, l, mid - 1, x);         
                    return binarySearch(arr, mid + 1, r, x);
                }         
                return -1;
            }
        }
```
    

## Inorder traversal on BINARY SEARCH TREE RESULTS in ASCENDING ORDER**


## Stack push and pop 

```


    Stack<Integer> a = new Stack<>();
    a.push( 5);
    a.push(7);
    while (!a.isEmpty()) {
        System.out.println(a.pop());
    }

```

## While using 2 pointer technique, think about the first
case where **either pointer get exhausted** **


## Regex Pattern Matching
```
String pattern = "[\\(]{1}[0-9]+[\\)]{1}$";
Pattern endsWith = Pattern.compile(pattern);
```
## Rotate a 1D Array by k 
**Using reverese**
```
Original List                   : 1 2 3 4 5 6 7
After reversing all numbers     : 7 6 5 4 3 2 1
After reversing first k numbers : 5 6 7 4 3 2 1
After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result

class Solution {
  public void rotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }
  
  public void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }
}

```




