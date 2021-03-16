package Hand;

import java.util.Arrays;

public class HandValue {
    public SetValue setValue;
    public int[] pointValue;

    public HandValue(SetValue setValue, int[] pointValue) {
        this.setValue = setValue;
        this.pointValue = pointValue;
    }

    public int CompareTo(HandValue that) {
        // 1 if true
        // -1 if false
        // 0 if tie

        if (this.setValue.ordinal() > that.setValue.ordinal()) {
            return 1;
        } else if (this.setValue.ordinal() < that.setValue.ordinal()) {
            return -1;
        } else {
            for (int i = 0; i < this.pointValue.length; i++) {
                if (this.pointValue[i] > that.pointValue[i]) {
                    return 1;
                } else if (this.pointValue[i] < that.pointValue[i]) {
                    return -1;
                }
            }
            return 0;
        }
    }
}
