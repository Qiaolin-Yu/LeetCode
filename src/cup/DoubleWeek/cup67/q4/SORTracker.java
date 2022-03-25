package cup.DoubleWeek.cup67.q4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author 1iin
 */
public class SORTracker {
    int index = 1;
    PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            if (o2.score - o1.score != 0) {
                return o2.score - o1.score;
            }
            return o1.name.compareTo(o2.name);
        }
    });

    public SORTracker() {

    }

    public void add(String name, int score) {
        priorityQueue.add(new Node(name, score));
    }

    public String get() {
        LinkedList<Node> temp = new LinkedList<>();
        int num = index;
        while (num > 1) {
            temp.add(priorityQueue.poll());
            num--;
        }
        index++;
        String res = priorityQueue.peek().name;
        while (temp.size() > 0) {
            priorityQueue.offer(temp.removeLast());
        }
        return res;
    }
}

class Node {
    String name;
    int score;

    public Node(String name, int score) {
        this.name = name;
        this.score = score;
    }


}
