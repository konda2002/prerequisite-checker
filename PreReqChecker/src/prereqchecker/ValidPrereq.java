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
 * ValidPreReqInputFile name is passed through the command line as args[1]
 * Read from ValidPreReqInputFile with the format:
 * 1. 1 line containing the proposed advanced course
 * 2. 1 line containing the proposed prereq to the advanced course
 * 
 * Step 3:
 * ValidPreReqOutputFile name is passed through the command line as args[2]
 * Output to ValidPreReqOutputFile with the format:
 * 1. 1 line, containing either the word "YES" or "NO"
 */
public class ValidPrereq {
    public static void main(String[] args) {

        if ( args.length < 3 ) {
            StdOut.println("Execute: java -cp bin prereqchecker.ValidPrereq <adjacency list INput file> <valid prereq INput file> <valid prereq OUTput file>");
            return;
        }

        StdIn.setFile(args[0]);

        Digraph graph = new Digraph();
        int vertices = StdIn.readInt();
        graph.digraph();

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

        String main = StdIn.readString();
        StdIn.readLine();
        String prereqs = StdIn.readString();
        StdIn.readLine();

        StdOut.setFile(args[2]);

        if (graph.valid(main, prereqs) == false) {
            StdOut.print("no");
        } else {
            StdOut.print("yes");

        }
    }
}
