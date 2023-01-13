## Array to List ()
It returns a **fixed sized list**

```
 String a[] = new String[] { "A", "B", "C", "D" };
            
 // Getting the list view of Array
 // runs in O(1)
  List<String> list = Arrays.asList(a);
  
  
  // adding element to the list would result in an UnSupportedException
  list.add ("c");
   //throws UnsupportedOperationException 
```


## List to array

```

List<String> itemList = new ArrayList<String>();
itemList.add("item1");
itemList.add("item2");
itemList.add("item3");

String[] itemsArray = new String[itemList.size()];
itemsArray = itemList.toArray(itemsArray);

```

## Custom Sorting
```
Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

```