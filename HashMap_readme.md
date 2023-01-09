# Iterate on Map

- Using entrySet
```
for (Map.Entry<String, Integer> entry : map.entrySet()) {
        System.out.println(entry.getKey() + ":" + entry.getValue());
    }
```
- Using keySet
```
  for (String key : map.keySet()) {
    System.out.println(key + ":" + map.get(key));
  }
```
- using values
```
public void iterateValues(Map<String, Integer> map) {
    for (Integer value : map.values()) {
        System.out.println(value);
    }
}
```

## Hashmap put
- if we try to add multiple keys with same value then the value gets overrided
```
    Map<Integer, Integer> tracker = new HashMap<Integer, Integer>();
    tracker.put(1, 100);
    tracker.put(1, 150);
    tracker.get(1); // returns 100
```

## HashMap insertion and retrieval takes O(1) time complexity.
## Default Capacity of HashMap is 16.
## Default Load Factor is 0.75

- containsKey() : O(1) in average case
- get(Object key): O(1) in average case
- put(key, value): O(1) in average case
- **Note: we can’t guarantee that since it all depends on how much time does it take to compute the hash**


## TreeMap can be a bit handy when we only need to store unique elements in a sorted order.
- TreeMap uses a **red-black tree** in the background which makes sure that there are no duplicates; additionally it also maintains the elements in a sorted order.
- This solution has more **time complexity O(n Log(n))** compared to hashmap which has O(n)


