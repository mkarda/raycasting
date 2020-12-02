package Google.DataStructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class LoggerRateLimiter {

    public static void main(String[] args) {

        Logger logger = new Logger();
        System.out.println(logger.shouldPrintMessage(1,"foo"));
        System.out.println(logger.shouldPrintMessage(20,"bar"));
    }

    class Logger2 {
        private final HashMap<String, Integer> msgDict;

        /** Initialize your data structure here. */
        public Logger2() {
            msgDict = new HashMap<String, Integer>();
        }

        /**
         * Returns true if the message should be printed in the given timestamp, otherwise returns false.
         */
        public boolean shouldPrintMessage(int timestamp, String message) {

            if (!this.msgDict.containsKey(message)) {
                this.msgDict.put(message, timestamp);
                return true;
            }

            Integer oldTimestamp = this.msgDict.get(message);
            if (timestamp - oldTimestamp >= 10) {
                this.msgDict.put(message, timestamp);
                return true;
            } else
                return false;
        }
    }





    static class Logger {
        private LinkedList<Pair<String, Integer>> msgQueue;
        private HashSet<String> msgSet;

        /** Initialize your data structure here. */
        public Logger() {
            msgQueue = new LinkedList<Pair<String, Integer>>();
            msgSet = new HashSet<String>();
        }

        /**
         * Returns true if the message should be printed in the given timestamp, otherwise returns false.
         */
        public boolean shouldPrintMessage(int timestamp, String message) {

            // clean up.
            while (msgQueue.size() > 0) {
                Pair<String, Integer> head = msgQueue.getFirst();
                if (timestamp - head.second >= 10) {
                    msgQueue.removeFirst();
                    msgSet.remove(head.first);
                } else
                    break;
            }

            if (!msgSet.contains(message)) {
                Pair<String, Integer> newEntry = new Pair<String, Integer>(message, timestamp);
                msgQueue.addLast(newEntry);
                msgSet.add(message);
                return true;
            } else
                return false;

        }
    }


    static class Pair<U, V> {
        public U first;
        public V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }
}
