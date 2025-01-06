/*
 * Vertex class representing a graph vertex
 * 
 * @variables:
    * label: Represents the label of the vertex
    * visited: Represents whether the vertex has been visited
 */

class Vertex {
    char label;
    boolean visited;

    public Vertex(char label) {
        this.label = label;
        this.visited = false;
    }
}
