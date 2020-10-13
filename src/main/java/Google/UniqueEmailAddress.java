package Google;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {



    public static void main(String[] args) {
        String[] input = new String[] {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        int uniqueEmails = getUniqueEmails(input);
        System.out.println(uniqueEmails);
    }

    private static int getUniqueEmails(String[] input) {

        Set<String> seen = new HashSet<>();

        for (String email : input) {

            int i = email.indexOf('@');

            String local = email.substring(0,i);
            String rest = email.substring(i);

            if (local.contains("+")) {
                local = local.substring(0, local.indexOf('+'));
            }

            local = local.replaceAll("\\.", "");
            seen.add(local + rest);
        }
        return seen.size();
    }
}
