# Get all possible substrings from a string
```
for (int i=0; i<s.length(); i++) {
    for (int j=i+1; j<=s.length(); j++) {
        // i is inclusive 
        // gets characters from i to j-1
        System.out.println(s.substring(i,j));
    }    
}
```
# Sort an array of strings TC: O (N Log(N))
```
Arrays.sort(strs);
```