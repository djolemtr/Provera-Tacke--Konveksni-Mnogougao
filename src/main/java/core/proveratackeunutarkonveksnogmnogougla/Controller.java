package core.proveratackeunutarkonveksnogmnogougla;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private TextField pointX;
    @FXML
    private TextField pointY;
    @FXML
    private TextField polygonX;
    @FXML
    private TextField polygonY;
    @FXML
    private TextField numOfVertexes;
    @FXML
    private Label enteredVertexes;
    @FXML
    private Label checkLabel;
    @FXML
    private Label numOfVerError;
    @FXML
    private Label checkResult;

    private List<Pair<Integer, Integer>> list = new ArrayList<>();
    private Polygon polygon = new Polygon(list);
    private NumericTextFormatter formatter = new NumericTextFormatter();
    private PointChecker pointChecker = new PointChecker();


    //disabling textual input in the fields
    public void initialize() {
        polygonX.setTextFormatter(formatter.createNumericTextFormatter());
        polygonY.setTextFormatter(formatter.createNumericTextFormatter());
        pointX.setTextFormatter(formatter.createNumericTextFormatter());
        pointY.setTextFormatter(formatter.createNumericTextFormatter());
        numOfVertexes.setTextFormatter(formatter.createNumericTextFormatter());
    }

    //BUTTONS
    @FXML
    protected void check() {
        //making sure all the fields are entered before checking
        if (!(numOfVertexes.getText().isBlank() || polygonX.getText().isBlank()
                || polygonY.getText().isBlank() || pointX.getText().isBlank()
                || pointY.getText().isBlank())) {
            //making sure desired amount of vertexes is entered
            if (Integer.valueOf(numOfVertexes.getText()) > list.size()) {

                int remainingV = (Integer.valueOf(numOfVertexes.getText())) - (list.size());

                if (remainingV == 1) {
                    checkLabel.setText("Unesite još " + remainingV + " teme.");
                } else {
                    checkLabel.setText("Unesite još " + remainingV + " temena.");
                }
            //final check
            } else {
                int x = Integer.valueOf(pointX.getText());
                int y = Integer.valueOf(pointY.getText());
                Pair<Integer, Integer> pair = new Pair<>(x, y);

                if (pointChecker.check(polygon, pair)) {
                    checkResult.setText("Tačka je unutar mnogougla.");
                } else {
                    checkResult.setText("Tačka nije unutar mnogougla.");
                }
            }
        } else {
            checkLabel.setText("Unesite sva polja.");
        }
    }

    @FXML
    protected void addVertex() {
        if (!(numOfVertexes.getText().isBlank() || polygonX.getText().isBlank()
                || polygonY.getText().isBlank())) {
            if (Integer.valueOf(numOfVertexes.getText()) == list.size()) {
                numOfVerError.setText("Uneli ste izabrani broj temena.");
            } else {
                checkLabel.setText("");
                int polX = Integer.valueOf(polygonX.getText());
                int polY = Integer.valueOf(polygonY.getText());
                Pair<Integer, Integer> c = new Pair<>(polX, polY);
                list.add(c);
                enteredVertexes.setText(polygon.toString());
                numOfVerError.setText("");
            }
        } else {
            numOfVerError.setText("Unesite sva polja.");
        }
    }

    @FXML
    protected void reset() {
        polygon.getVertexes().clear();
        list.clear();
        pointX.clear();
        pointY.clear();
        polygonX.clear();
        polygonY.clear();
        numOfVertexes.clear();
        enteredVertexes.setText("");
        checkLabel.setText("");
        numOfVerError.setText("");
        checkResult.setText("");
    }

}