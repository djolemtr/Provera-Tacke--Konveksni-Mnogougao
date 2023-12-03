package core.proveratackeunutarkonveksnogmnogougla;

import javafx.util.Pair;

import java.util.List;

public class Polygon {
    private List<Pair<Integer, Integer>> vertexes;

    public Polygon(List<Pair<Integer, Integer>> vertexes) {
        this.vertexes = vertexes;
    }

    public List<Pair<Integer, Integer>> getVertexes() {
        return vertexes;
    }

    public void setVertexes(List<Pair<Integer, Integer>> vertexes) {
        this.vertexes = vertexes;
    }

    @Override
    public String toString() {
        String string = "";

        for (Pair<Integer, Integer> coordinate : vertexes) {
            int x = coordinate.getKey();
            int y = coordinate.getValue();

            if (string.isBlank()) {
                string += "(" + x + ", " + y + ")";
            } else {
                string += ", (" + x + ", " + y + ")";
            }
        }

        return string;

    }
}
