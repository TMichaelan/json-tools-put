package pl.put.poznan.transformer.logic.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.transformer.logic.domain.JSONException;
import pl.put.poznan.transformer.logic.domain.JSONObject;

import static pl.put.poznan.transformer.logic.tools.JsonParser.parse;


/**
 * The type Json tool prettify.
 */
public class PrettifyTool extends DecoratorTool {
    private static Logger logger = LoggerFactory.getLogger(PrettifyTool.class);

    public PrettifyTool() {
        super();
    }

    /**
     * Instantiates a new Json tool prettify.
     *
     * @param json the json
     */
    public PrettifyTool(IJsonTool json) {
        super(json);
    }

    @Override
    public JSONObject decorate(JSONObject json) throws JSONException {
        logger.debug("Decorating!");
        if (wrappee != null) {
            logger.debug("I am a wrapper.");
            return pretty(super.decorate(json));
        } else {
            logger.debug("I am a Starting point");
            return pretty(json);
        }

    }

    /**
     * Pretty json object.
     *
     * @param json the json
     * @return the json object
     */
    public JSONObject pretty(JSONObject json) throws JSONException {
        logger.info("Prettyfing:\n"+ json.getJson());
        JSONObject tmpJson = new JSONObject(parse(json.getJson()).toPrettyString());
        logger.info("Prettification returned:\n" + tmpJson.getJson());
        return tmpJson;
    }
}
