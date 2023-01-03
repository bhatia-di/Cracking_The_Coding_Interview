# Print array to console

```
Arrays.toString(nums);
```

# Shift elements in an array
```
    void shift(int index, int[] arr) {
        int prev = arr[index];
        for (int j = index + 1; j < arr.length; j++) {
            int temp = arr[j];
            arr[j] = prev;
            prev = temp;
        }
    }
```