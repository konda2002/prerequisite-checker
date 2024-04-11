package prereqchecker;

import java.util.*;

/**
 * Steps to implement this class main method:
 * 
 * Step 1:
 * AdjListInputFile name is passed through the command line as args[0]
 * Read from AdjListInputFile with the format:
 * 1. a (int): number of courses in the graph
 * 2. a lines, each with 1 course ID
 * 3. b (int): number of edges in the graph
 * 4. b lines, each with a source ID
 * 
 * Step 2:
 * NeedToTakeInputFile name is passed through the command line as args[1]
 * Read from NeedToTakeInputFile with the format:
 * 1. One line, containing a course ID
 * 2. c (int): Number of courses
 * 3. c lines, each with one course ID
 * 
 * Step 3:
 * NeedToTakeOutputFile name is passed through the command line as args[2]
 * Output to NeedToTakeOutputFile with the format:
 * 1. Some number of lines, each with one course ID
 */
public class NeedToTake {
    public static void main(String[] args) {

        if ( args.length < 3 ) {
            StdOut.println("Execute: java NeedToTake <adjacency list INput file> <need to take INput file> <need to take OUTput file>");
            return;
        }


        StdIn.setFile(args[0]);

        Digraph graph = new Digraph();
        int vertices = StdIn.readInt();

        String[] courses = new String[vertices];
        StdIn.readLine();

        for (int i = 0; i < vertices; i++) {

            String vertex = StdIn.readString();
            graph.addVert(vertex);
            courses[i] = vertex;

            StdIn.readLine();
        }

        int lines = StdIn.readInt();
        StdIn.readLine();

        for (int i = 0; i < lines; i++) {
            String current = StdIn.readString();
            String prereq = StdIn.readString();
            StdIn.readLine();
            graph.addEdge(current, prereq);
        }

        StdIn.setFile(args[1]);

        String targetcourse = StdIn.readString();
        StdIn.readLine();
        int numbers = StdIn.readInt();
        StdIn.readLine();

        ArrayList<String> taken1 = new ArrayList<>();

        for (int i = 0; i < numbers; i++) {
            taken1.add(StdIn.readString());
            StdIn.readLine();
        }

        Stack<String> dfs = new Stack<>();
        for (String x : taken1) {
            dfs.push(x);
        }
        ArrayList<String> taken2 = new ArrayList<>();

        while (!dfs.isEmpty()) {
            String course = dfs.pop();
            if (!taken2.contains(course)) {
                taken2.add(course);
                for (String connected : graph.adj(course)) {
                    dfs.push(connected);
                }
            }
        }

        Stack<String> dfs2 = new Stack<>();
        for (String g : graph.adj(targetcourse)) {
            dfs2.push(g);
        }

        ArrayList<String> eligibletotake = new ArrayList<>();

        while (!dfs2.isEmpty()) {
            String c = dfs2.pop();
            if (!eligibletotake.contains(c)) {
                eligibletotake.add(c);
                for (String q : graph.adj(c)) {
                    dfs2.push(q);
                }
            }
        }

        ArrayList<String> needtotake = new ArrayList<>();

        for (String vi : eligibletotake) {
            if (!taken2.contains(vi)) {
                needtotake.add(vi);
            }
        }

        StdOut.setFile(args[2]);

        for (String l : needtotake) {
            StdOut.println(l);
        }
    }
}
