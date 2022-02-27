package strings;

class UniqueCountSubsring {
    public int uniqueLetterString(String s) {
        int finalCount = 0;

        for (int i=0; i<s.length(); i++) {
            for (int j=i+1; j<=s.length(); j++) {

                if (j-i==1) {

                    finalCount+=1;
                    continue;
                }
                finalCount += countUniqueChars(s.substring(i,j));
            }
        }
        //countUniqueChars("LEETCODE");
        return finalCount;

    }

    public int countUniqueChars(String input) {
//         if (input.length() == 1) return 1;

//         Map<Character, Integer> track = new HashMap<>();
//         int unique = 0;
//         for (int i =0; i< input.length(); i++) {
//             char c = input.charAt(i);
//             track.put(c, track.getOrDefault(c, 0) + 1);
//             int trackerValue = track.get(c);
//             if (trackerValue == 1) {
//                 unique++;
//             } else if (trackerValue == 2) {
//                 unique--;
//             }
//         }
        System.out.println("String " + input + " replaced " + input.replaceAll("[A-Z]{2}", ""));
//         return unique;

        return 0;
    }


    public static void main(String[] args) {
        UniqueCountSubsring u = new UniqueCountSubsring();
        u.uniqueLetterString("LEETCODE");
    }
}