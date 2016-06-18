package DataStructures;

/**
 * Created by squeaky on 6/18/16
 * ***Vertexes will not hold data in this representation, nor will they be added or deleted!***
 */
public class AdjacencyMatrixGraph {
    private Integer graph [][];
    private int vertexCount;

    AdjacencyMatrixGraph(int vertexCount) {
        this.vertexCount = vertexCount;
        graph = new Integer[vertexCount][vertexCount];
    }

    public void addEdge(int fromVertex, int toVertex) {
        if(checkVertex(fromVertex) && checkVertex(toVertex)) {
            graph[fromVertex][toVertex] = 1;
        }
    }

    private boolean checkVertex(int vertex) {
        return vertex >= 0 && vertex < vertexCount;
    }

    public void addEdge(int fromVertex, int toVertex, int weight) {
        if(checkVertex(fromVertex) && checkVertex(toVertex)) {
            graph[fromVertex][toVertex] = weight;
        }
    }

    public void removeEdge(int fromVertex, int toVertex) {
        if(checkVertex(fromVertex) && checkVertex(toVertex)) {
            graph[fromVertex][toVertex] = null;
        }
    }

    public Integer getEdge(int fromVertex, int toVertex) {
        if(checkVertex(fromVertex) && checkVertex(toVertex)) {
            return graph[fromVertex][toVertex];
        } else {
            throw new IllegalArgumentException("Check passed vertex values"); //TODO: Better log message
        }
    }

    public boolean hasEdge(int fromVertex, int toVertex) {
        return getEdge(fromVertex, toVertex) != null;
    }

}
