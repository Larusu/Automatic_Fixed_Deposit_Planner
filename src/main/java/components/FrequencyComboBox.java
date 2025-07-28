package components;

import javax.swing.JComboBox;

public class FrequencyComboBox extends JComboBox<String> {

    public enum Frequency {
        ANNUALLY("Annually"),
        SEMIANNUALLY("Semiannually"),
        QUARTERLY("Quarterly"),
        MONTHLY("Monthly");

        private final String label;

        Frequency(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    public FrequencyComboBox() {
        super();
        for (Frequency freq : Frequency.values()) {
            this.addItem(freq.toString());
        }
    }
}
