package limitless;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Lelental on 09.06.2017.
 */
public class LimitlessSpeechletRequestStreamHandler extends SpeechletRequestStreamHandler {
    private static final Set<String> supportedApplicationIds;

    static {
        supportedApplicationIds = new HashSet<String>();
        supportedApplicationIds.add("<Our Api Key>");

    }

    public LimitlessSpeechletRequestStreamHandler() {
        super(new LimitlessSpeechlet(), supportedApplicationIds);
    }
}
