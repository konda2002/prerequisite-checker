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
 * AdjListOutputFile name is passed through the command line as args[1]
 * Output to AdjListOutputFile with the format:
 * 1. c lines, each starting with a different course ID, then 
 *    listing all of that course's prerequisites (space separated)
 */
public class AdjList {
    public static void main(String[] args) {

        if ( args.length < 2 ) {
            StdOut.println("Execute: java -cp bin prereqchecker.AdjList <adjacency list INput file> <adjacency list OUTput file>");
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

        StdOut.setFile(args[1]);
        for (int i = 0; i < vertices; i++) {

            StdOut.print(courses[i] + " ");

            ArrayList<String> prereqs = graph.adj(courses[i]);

            for (int j = 0; j < prereqs.size(); j++) {
                StdOut.print(prereqs.get(j) + " ");
            }

            StdOut.println();

        }
    }
}
