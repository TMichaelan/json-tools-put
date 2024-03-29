package pl.put.poznan.transformer.logic.tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.transformer.logic.domain.JSONException;
import pl.put.poznan.transformer.logic.domain.JSONObject;

/**
 * The type Json tool blacklist.
 */
public class BlacklistTool extends FilterTool {
    private static Logger logger = LoggerFactory.getLogger(BlacklistTool.class);

    /**
     * Instantiates a new Json tool minify.
     *
     * @param filterList the filter list
     */
    public BlacklistTool(String[] filterList) {
        super(filterList);
    }

    /**
     * Instantiates a new Json tool blacklist.
     *
     * @param tool       the tool
     * @param filterList the filter list
     */
    public BlacklistTool(IJsonTool tool, String[] filterList) {
        super(tool, filterList);
    }

    @Override
    public JSONObject decorate(JSONObject json) throws JSONException {
        logger.debug("Decorating!");
        if (wrappee != null) {
            logger.debug("I am a wrapper.");
            return super.decorate(json);
        } else {
            logger.debug("I am a Starting point");
            return blacklist(json);
        }
    }


    /**
     * Whitelist json object.
     * filterlist w kontruktorze
     *
     * @param json the json
     * @return the json object
     */
    private JSONObject blacklist(JSONObject json) {
        if (filterList == null) {
            logger.info("BlackList is empty");
            return json;
        } else {
            logger.info("BlackList is not empty");
            return new JSONObject("to musisz zmienić");
        }
    }


}