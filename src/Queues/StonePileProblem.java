package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StonePileProblem {
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                q.add(sc.nextInt());
            }

            int player = 0;

            while (q.size() > 1) {
                if (player == 0) {
                    q.add(q.remove());
                    q.remove();
                } else {
                    q.add(q.remove());
                    q.add(q.remove());
                    q.remove();
                }
                player = 1 - player;
            }
            System.out.println(player + " " + q.peek());
        }

        sc.close();
	}
}

