package graphs;

import java.util.HashSet;
import java.util.Set;

public class Graph {

	// adjacency matrix
	private boolean[][] A;

	public Graph(int vertexes) {
		A = new boolean[vertexes][vertexes];
	}

	private void validateDiffentVertexes(int i, int j) {
		if (i == j)
			throw new IllegalArgumentException("Loops aren't allowed: (" + i + " , " + j + ")");
	}

	private void validVertex(int i) {
		if (i < 0)
			throw new IllegalArgumentException("Parameter mustn't be negative: " + i);
		if (i >= A.length)
			throw new IllegalArgumentException("Edges must be between 0 and |V|-1: " + i);
	}

	public void addEdge(int i, int j) {
		validVertex(i);
		validVertex(j);
		validateDiffentVertexes(i, j);

		A[i][j] = true;
		A[j][i] = true;
	}

	public void removeEdge(int i, int j) {
		validVertex(i);
		validVertex(j);
		validateDiffentVertexes(i, j);

		A[i][j] = false;
		A[j][i] = false;
	}

	public boolean existsEdge(int i, int j) {
		validVertex(i);
		validVertex(j);

		return A[i][j];
	}

	public int length() {
		return A.length;
	}

	public Set<Integer> getNeighbors(int i) {
		validVertex(i);

		Set<Integer> ret = new HashSet<Integer>();
		for (int j = 0; j < length(); ++j)
			if (i != j) {
				if (existsEdge(i, j))
					ret.add(j);
			}
		return ret;
	}
}
