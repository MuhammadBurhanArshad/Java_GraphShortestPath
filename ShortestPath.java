/*
 * Main class for testing the shortest path
 * 
 * @methods:
    * main(String[] args): Main method to test the shortest path
 */

public class ShortestPath {
    public static void main(String[] args) {
        char[] vertices = { 'A', 'B', 'C', 'D', 'E' };

        GraphShortestPath graph = new GraphShortestPath(vertices);
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('B', 'C');
        graph.addEdge('B', 'D');
        graph.addEdge('C', 'E');

        graph.findShortestPath('A', 'E');
    }
}
