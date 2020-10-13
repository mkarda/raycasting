package Google;

public class SmallPrograms {

    public static void main(String[] args) {


        String input = "        I         ";

        System.out.println(removeEmptySpaces(input));
    }


    static String removeEmptySpaces(String input) {
        char[] in = input.toCharArray();
        int initialIndex = in.length-1;
        for (int c = 0; c < input.length(); c++) {
            if (in[c] != ' ') {
                initialIndex = c;
                break;
            }
        }

        int stopIndex = 0;
        for (int i = 1; i < input.length(); i++) {
            if (in[in.length - i] != ' ') {
                stopIndex = in.length - i;
                break;
            }
        }

            char[] out = new char[in.length];
            boolean spaceFound = false;
            int outIndex = 0;
            for (int i2 = initialIndex; i2 <= stopIndex; i2++) {

                if (in[i2] == ' ') {
                    if (!spaceFound) {
                        spaceFound = true;
                        out[outIndex] = in[i2];
                        outIndex++;
                    }
                } else {
                    out[outIndex] = in[i2];
                    outIndex++;
                    spaceFound = false;
                }
            }

            return String.valueOf(out);
        }
}
