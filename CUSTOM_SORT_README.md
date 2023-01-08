# Comparator
```

int compare(T o1, T o2) {
    if (o1 < o2)
        return -1;
    else if (o1 == o2)
        return 0;
    else // o1 > o2
    return 1;
}
```


# Say you want to sort a 2D array based on the first element

```
int[][] intervals = [[1,3],[2,6],[33, 39], [8,10],[15,18]]
Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]);`
output: [[1,3],[2,6], [8,10],[15,18], [33, 39]]`
```

# Another way to write a custom sort for any array String based on a custom order
```

    Comparator<String> logComparator = new Comparator<String>() {

            @Override            
            public int compare(String s1, String s2) { 
            
            String[] a = s1.split(" ");
            String[] b = s2.split(" ");
            boolean isDigitA = Character.isDigit(a[1].charAt(0));  
            boolean isDigitB = Character.isDigit(b[1].charAt(0));       
            int firstSpaceA = s1.indexOf(" ");
            int firstSpaceB = s2.indexOf(" ");
            int lengthA = s1.length();
            int lengthB = s2.length();
                
                
                
            if (isDigitA && !isDigitB) {
                return 1;
            } else if (!isDigitA && isDigitB) {
                return -1;
            } else if (isDigitA && isDigitB) {
                return 0;
            } else {
                int cmpValue = s1.substring(firstSpaceA, lengthA).compareTo(s2.substring(firstSpaceB, lengthB));
                
                if (cmpValue == 0) return s1.compareTo(s2);
                return cmpValue;
                    
            }
            
       
        }
    };
   Arrays.sort(logs, logComparator);
```

# General Idea behind designing custom sort function
```
   
if parmeter1 > parmeter2 return -1
if parmeter1 < parmeter2 return 1
is parmeter1 == parmeter2 return 0
```
