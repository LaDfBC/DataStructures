package DataStructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by squeaky on 6/18/16
 */
public class AdjacencyListGraph<T> {
    public class Vertex {
        T data;
        List<Edge> edges;

        Vertex(T data) {
            this.data = data;
            this.edges = new ArrayList<>();
        }
    }

    public class Edge {
        int weight;
        int toVertex;

        Edge(int weight, int toVertex) {
            this.weight = weight;
            this.toVertex = toVertex;
        }

        Edge(int toVertex) {
            this.toVertex = toVertex;
            this.weight = 1;
        }
    }

    List<Vertex> graph;

    //Returns the integer representation of this vertex.  You'll need to use this to reference the vertex
    //  in the future instead of with the data it holds.
    public int addVertex(T data) {
        Vertex v = new Vertex(data);
        graph.add(v);
        return graph.size() - 1;
    }

    public void addEdge(final int fromVertex, final int toVertex) {
        Edge e = new Edge(toVertex);
        graph.get(fromVertex).edges.add(e);
    }

    public void addEdge(final int fromVertex, final int toVertex, final int weight) {
        Edge e = new Edge(weight, toVertex);
        graph.get(fromVertex).edges.add(e);
    }

    public void removeEdge(final int fromVertex, final int toVertex) {
        for(Edge e : graph.get(fromVertex).edges) {
            if(e.toVertex == toVertex) {
                graph.get(fromVertex).edges.remove(e);
                return;
            }
        }
    }

    public boolean hasEdge(final int fromVertex, final int toVertex) {
        for(Edge e : graph.get(fromVertex).edges) {
            if(e.toVertex == toVertex) {
                return true;
            }
        }

        return false;
    }

    /**
     * By far the most expensive operation for this Graph.  Avoid as much as possible.
     * @param vertex - the vertext to remove
     */
    public void removeVertex(final int vertex) {
        for (Vertex v : graph) {
            for (Edge e : v.edges) {
                if (e.toVertex == vertex) {
                    v.edges.remove(e);
                    break;
                }
            }
        }

        graph.remove(vertex);
    }

}
