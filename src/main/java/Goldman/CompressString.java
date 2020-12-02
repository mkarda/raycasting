package Goldman;

public class CompressString {

    public static void main(String[] args) {
        String in = "fdsfrfsrfdddddd";
        int compress = compress(in.toCharArray());
        System.out.println(compress);
    }

    public static int compress(char[] chars) {
        int anchor = 0, write = 0;

        for (int read = 0; read < chars.length; read++) {

            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }

    public int compress2(char[] chars) {
        int index =0;
        for ( int i =0; i < chars.length;i++) {
            int count =1;
            while( i< chars.length -1 && chars[i]== chars[i+1]) {
                i++;
                count++;
            }
            chars[index] = chars[i];
            index++;
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[index] = c;
                    index++;
                }

            }
        }
        return index;
    }
}
