/*
 * Graph class to find the shortest path
 * 
 * @variables:
    * vertices: Array of vertices
    * adjacencyMatrix: Adjacency matrix representation
    * vertexCount: Number of vertices
 *
 * @methods:
    * GraphShortestPath(char[] vertexLabels): Initializes the graph with the given vertex labels
    * addEdge(char u, char v): Adds an edge (u, v)
    * getIndex(char vertex): Returns the index of a vertex
    * findShortestPath(char startVertex, char endVertex): Finds the shortest path from startVertex to endVertex
    * reconstructPath(char startVertex, char endVertex): Returns the shortest path from startVertex to endVertex
 */

class GraphShortestPath {
    private Vertex[] vertices;
    private int[][] adjacencyMatrix;
    private int vertexCount;

    public GraphShortestPath(char[] vertexLabels) {
        vertexCount = vertexLabels.length;
        vertices = new Vertex[vertexCount];
        adjacencyMatrix = new int[vertexCount][vertexCount];

        for (int i = 0; i < vertexCount; i++) {
            vertices[i] = new Vertex(vertexLabels[i]);
            for (int j = 0; j < vertexCount; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }

    public void addEdge(char u, char v) {
        int uIndex = getIndex(u);
        int vIndex = getIndex(v);
        if (uIndex != -1 && vIndex != -1) {
            adjacencyMatrix[uIndex][vIndex] = 1;
            adjacencyMatrix[vIndex][uIndex] = 1;
        }
    }

    private int getIndex(char vertex) {
        for (int i = 0; i < vertexCount; i++) {
            if (vertices[i].label == vertex) {
                return i;
            }
        }
        return -1;
    }

    public void findShortestPath(char startVertex, char endVertex) {
        int startIndex = getIndex(startVertex);
        int endIndex = getIndex(endVertex);
        if (startIndex == -1 || endIndex == -1) {
            System.out.println("Start or End vertex not found");
            return;
        }

        int[] parent = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            parent[i] = -1;
        }

        CustomQueue queue = new CustomQueue(vertexCount);

        vertices[startIndex].visited = true;
        queue.enqueue(vertices[startIndex]);

        boolean pathFound = false;

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.dequeue();
            int currentIndex = getIndex(currentVertex.label);

            for (int i = 0; i < vertexCount; i++) {
                if (adjacencyMatrix[currentIndex][i] == 1 && !vertices[i].visited) {
                    vertices[i].visited = true;
                    parent[i] = currentIndex;
                    queue.enqueue(vertices[i]);

                    if (vertices[i].label == endVertex) {
                        pathFound = true;
                        break;
                    }
                }
            }

            if (pathFound) {
                break;
            }
        }

        if (!pathFound) {
            System.out.println("No path found between " + startVertex + " and " + endVertex);
            return;
        }

        reconstructPath(parent, startIndex, endIndex);
    }

    private void reconstructPath(int[] parent, int startIndex, int endIndex) {
        int current = endIndex;
        int[] path = new int[vertexCount];
        int pathLength = 0;

        while (current != -1) {
            path[pathLength++] = current;
            current = parent[current];
        }

        System.out.print("Shortest Path: ");
        for (int i = pathLength - 1; i >= 0; i--) {
            System.out.print(vertices[path[i]].label + " ");
        }
        System.out.println("\nPath Length: " + (pathLength - 1));
    }
}
