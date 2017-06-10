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
        supportedApplicationIds.add("amzn1.ask.skill.4e013145-5d3f-454b-adbe-a8509f611300");

    }

    public LimitlessSpeechletRequestStreamHandler() {
        super(new LimitlessSpeechlet(), supportedApplicationIds);
    }
}
