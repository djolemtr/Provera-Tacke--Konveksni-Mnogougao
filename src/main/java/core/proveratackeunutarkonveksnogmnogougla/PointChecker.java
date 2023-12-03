package core.proveratackeunutarkonveksnogmnogougla;

import javafx.util.Pair;

public class PointChecker {

    public boolean check(Polygon polygon, Pair<Integer, Integer> point) {
        //preuzimanje tacke
        int x = point.getKey();
        int y = point.getValue();
        int n = polygon.getVertexes().size();
        boolean isInside = false;

        for (int i = 1; i <= n; i++) {
            int x1 = polygon.getVertexes().get(i - 1).getKey();
            int y1 = polygon.getVertexes().get(i - 1).getValue();

            //ako je i jednak poslednjem indeksu, sa modulo vracamo
            // index na 0 i time uzimamo pocetnu vrednost mnogougla da bi zatvorili linije
            int x2 = polygon.getVertexes().get(i % n).getKey();
            int y2 = polygon.getVertexes().get(i % n).getValue();

            //formula za kalkulaciju da li je tacka unutar konveksnog mnogougla
            if ((y1 <= y && y < y2 || y2 <= y && y < y1) &&
                    (x < (x2 - x1) * (y - y1) / (y2 - y1) + x1)) {
                isInside = true;
            }
        }
        return isInside;
    }

}

