package Google;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LicenceKeyFormatting {

    public static void main(String[] args) {

        String S = "5F3Z-2e-9-w";
        int k = 4;

        String result = formatKey(S, k);
        System.out.println(result);



    }

    private static String formatKey(String s, int elementCount) {

        String s1 = s.replaceAll("-", "");

        int firstCount = s1.length() % elementCount;

        List<String> parts = new ArrayList<>();
        if (firstCount != 0) {
            parts.add(s1.substring(0, firstCount));
        }

        int c= firstCount;
        while (c < s1.length()) {
            parts.add(s1.substring(c, c+elementCount));
            c = c+ elementCount;
        }

        return parts.stream()
                .map(s2 -> s2.toUpperCase())
                .collect(Collectors.joining("-"));
    }
}
