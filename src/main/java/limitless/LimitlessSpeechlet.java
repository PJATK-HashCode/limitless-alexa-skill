package limitless;

import com.amazon.speech.slu.Slot;
import com.amazon.speech.speechlet.*;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.SimpleCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.amazon.speech.speechlet.*;

/**
 * @author Lelental on 09.06.2017.
 */
public class LimitlessSpeechlet implements Speechlet {

    private static final Logger log = LoggerFactory.getLogger(LimitlessSpeechlet.class);

    public void onSessionStarted(SessionStartedRequest sessionStartedRequest, Session session) throws SpeechletException {
        log.info("onSessionStarted requestId={}, sessionId={}", sessionStartedRequest.getRequestId(),
                session.getSessionId());
    }

    public SpeechletResponse onLaunch(LaunchRequest launchRequest, Session session) throws SpeechletException {
        log.info("onLaunch requestId={}, sessionId={}", launchRequest.getRequestId(), session.getSessionId());

        return getWelcomeResponse();
    }

    public SpeechletResponse onIntent(IntentRequest intentRequest, Session session) throws SpeechletException {
        return null;
    }

    public void onSessionEnded(SessionEndedRequest sessionEndedRequest, Session session) throws SpeechletException {
        log.info("onSessionEnded requestId={}, sessionId={}", sessionEndedRequest.getRequestId(),
                session.getSessionId());
    }

    private SpeechletResponse getWelcomeResponse() {

        String speechText = "Welcome in Limitless Skill. Please tell your client id";

        SimpleCard card = new SimpleCard();
        card.setTitle("WelcomeResponse");
        card.setContent(speechText);

        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        SpeechletResponse response = new SpeechletResponse();
        response.setCard(card);
        response.setOutputSpeech(speech);

        return response;
    }
}
