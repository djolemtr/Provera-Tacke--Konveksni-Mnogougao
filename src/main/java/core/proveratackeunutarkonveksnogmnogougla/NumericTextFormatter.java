package core.proveratackeunutarkonveksnogmnogougla;

import javafx.scene.control.TextFormatter;
import javafx.util.converter.IntegerStringConverter;

public class NumericTextFormatter {

    public TextFormatter<Integer> createNumericTextFormatter() {
        return new TextFormatter<>(new IntegerStringConverter(), null, change -> {
            String newText = change.getControlNewText();

            if (newText.matches("\\d*")) {
                return change;
            } else {
                return null;
            }
        });
    }

}
