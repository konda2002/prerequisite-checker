package prereqchecker;
import java.util.*;


public class Digraph {
    private int vertices=0;
    private HashMap<String, ArrayList<String>> map = new HashMap<>();   


    public void digraph(){
        map = new HashMap<String,ArrayList<String>>();
    }


    public void addEdge(String v,String z){
        map.get(v).add(z);
    }
    
    //Because we are given "a" initial and "b" connections, we can just split it into two seperate methods to be cleaner:
    public void addVert(String v) {
        if (map.get(v) == null) {
            vertices++;
            map.put(v, new ArrayList<String>());
        }
    }

    public ArrayList<String> adj(String v){
        return map.get(v); 
    }

    public int getvertices(){
        return vertices;
    }

    public HashMap<String,ArrayList<String>> getmap(){
        return map;
    }

    public boolean valid(String a, String b) {
        Stack<String> dfs = new Stack<>();
        dfs.push(b);
        ArrayList<String> marked = new ArrayList<>();
        while(!dfs.isEmpty()) {

            String course = dfs.pop();

            if (!marked.contains(course)) {
                marked.add(course);
                for (String connected : adj(course)) {
                    dfs.push(connected);                    
                }
            }  if (course.equals(a)) {
                return false;
            }
        }

        return true;
    }

    
}
