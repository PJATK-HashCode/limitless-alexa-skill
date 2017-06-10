package limitless;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.*;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.SimpleCard;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Arrays;

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
        SpeechletResponse response = new SpeechletResponse();
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        SimpleCard card = new SimpleCard();

        Intent intent = intentRequest.getIntent();
        String intentName = (intent != null) ? intent.getName() : null;

        if ("Details".equals(intentName)) {
            return getDetails();
        } else if ("AMAZON.StopIntent".equals(intentName)) {
            PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
            outputSpeech.setText("Goodbye");
            return SpeechletResponse.newTellResponse(outputSpeech);
        }

        card.setTitle(intentName);
        card.setContent(speech.getText());
        response.setOutputSpeech(speech);
        response.setCard(card);
        return null;
    }

    public void onSessionEnded(SessionEndedRequest sessionEndedRequest, Session session) throws SpeechletException {
        log.info("onSessionEnded requestId={}, sessionId={}", sessionEndedRequest.getRequestId(),
                session.getSessionId());
    }

    private SpeechletResponse getWelcomeResponse() {

        String speechText = "Welcome in Limitless Skill";

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

    private SpeechletResponse getDetails() {
        try {
            Reader reader = new InputStreamReader
                    (new URL("<Our Url>")
                            .openStream());
            Gson gson = new GsonBuilder().create();
            DataObject[] obj = gson.fromJson(reader, DataObject[].class);
            PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
            speech.setText(Jsoup.parse(Arrays.toString(obj)).text());
            return SpeechletResponse.newTellResponse(speech);

        } catch (Exception e) {
            e.printStackTrace();
        }

        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText("We've got a problem with connecting to limitless database. Try again later");
        return SpeechletResponse.newTellResponse(speech);
    }
}
