###### **Cracking the Coding Interview with Leetcode and oher resources**

**#Reversing, Sorting A List**

    List<String> colors = new ArrayList<>(Arrays.asList("RED", "BLUE", "BLACK"));
    Collections.reverse(colors);
    Collections.sort(colors);

**#Binary Search on a sorted List**
        

    **int binarySearch(int arr[], int l, int r, int x)
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
        }**

**# Inorder traversal on BINARY SEARCH TREE RESULTS in ASCENDING ORDER**


**# Stack push and pop **
/**

    Stack<Integer> a = new Stack<>();
    a.push( 5);
    a.push(7);
    while (!a.isEmpty()) {
        System.out.println(a.pop());
    }

**/