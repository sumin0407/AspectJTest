package property;

import log.Log;
import log.Snapshot;
import property.pattern.UniversalityChecker;

import java.util.StringTokenizer;

public class MCIUniversalityChecker extends UniversalityChecker {

    public MCIUniversalityChecker() {
        super();
    }

    @Override
    protected boolean evaluateState(Snapshot snapshot, Property verificationProperty) {
        StringTokenizer st = new StringTokenizer(snapshot.getSnapshotString(), " ");
        while (st.hasMoreTokens()) {
            String target = st.nextToken();
            if (target.equals("RescuedRate:"))
                break;
        }

        double rescueRate = Double.parseDouble(st.nextToken());
        System.out.println(rescueRate);

        return rescueRate <= verificationProperty.getThresholdValue() && rescueRate > 0;
    }

    @Override
    public boolean check(Log log, Property verificationProperty, int until) {
        return false;
    }

    @Override
    public boolean check(Log log, Property verificationProperty, double prob, int T) {
        return false;
    }

    @Override
    public boolean check(Log log, Property verificationProperty, double prob, int t, int T) {
        return false;
    }

    @Override
    public boolean check(Log log, Property verificationProperty, int t, int T) {
        return false;
    }

    @Override
    protected boolean evaluateState(Log log, Property verificationProperty) {
        return false;
    }
}
