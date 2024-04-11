package prereqchecker;

import java.util.*;

/**
 * 
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
 * EligibleInputFile name is passed through the command line as args[1]
 * Read from EligibleInputFile with the format:
 * 1. c (int): Number of courses
 * 2. c lines, each with 1 course ID
 * 
 * Step 3:
 * EligibleOutputFile name is passed through the command line as args[2]
 * Output to EligibleOutputFile with the format:
 * 1. Some number of lines, each with one course ID
 */
public class Eligible {
    public static void main(String[] args) {

        if ( args.length < 3 ) {
            StdOut.println("Execute: java -cp bin prereqchecker.Eligible <adjacency list INput file> <eligible INput file> <eligible OUTput file>");
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
        ArrayList<String> coursestaken = new ArrayList<>();
        while (StdIn.hasNextLine()) {
            coursestaken.add(StdIn.readString());
            StdIn.readLine();
        }

        Stack<String> dfs = new Stack<>();
        for (String x : coursestaken) {
            dfs.push(x);
        }
        ArrayList<String> taken = new ArrayList<>();

        while (!dfs.isEmpty()) {
            String course = dfs.pop();
            if (!taken.contains(course)) {
                taken.add(course);
                ArrayList<String> adj = graph.adj(course);
                if (adj != null) {
                    for (String connected : graph.adj(course)) {
                        dfs.push(connected);
                    }
                }
            }
        }

        ArrayList<String> eligible = new ArrayList<String>();
        for (String y : courses) {

            if (!taken.contains(y) && !eligible.contains(y) && taken.containsAll(graph.adj(y))) {
                eligible.add(y);
            }

        }

        StdOut.setFile(args[2]);
        for (String e : eligible) {
            StdOut.println(e);
        }
    }
}
