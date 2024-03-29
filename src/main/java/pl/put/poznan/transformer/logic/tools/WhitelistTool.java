package pl.put.poznan.transformer.logic.tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.transformer.logic.domain.JSONException;
import pl.put.poznan.transformer.logic.domain.JSONObject;
/**
 * The type Json tool whitelist.
 */

public class WhitelistTool extends FilterTool {
    private static Logger logger = LoggerFactory.getLogger(WhitelistTool.class);

    /**
     * Instantiates a new Json tool minify.
     *
     * @param filterList the filter list
     */
    public WhitelistTool(String[] filterList) {
        super(filterList);
    }

    /**
     * Instantiates a new Json tool whitelist.
     *
     * @param tool       the tool
     * @param filterList the filter list
     */
    public WhitelistTool(IJsonTool tool, String[] filterList) {
        super(tool, filterList);
    }

    @Override
    public JSONObject decorate(JSONObject json) throws JSONException {
        logger.debug("Decorating!");
        if (wrappee != null) {
            logger.debug("I am a wrapper.");
            return whitelist(super.decorate(json));
        } else {
            logger.debug("I am a Starting point");
            return whitelist(json);
        }
    }

    /**
     * Whitelist json object.
     * filterlist w kontruktorze
     *
     * @param json the json
     * @return the json object
     */
    private JSONObject whitelist(JSONObject json) {
        if (this.filterList == null) {
            logger.info("WhiteList is empty");
            return new JSONObject("");
        } else {
            logger.info("WhiteList is not empty");
            return new JSONObject("to musisz zmienić");
        }

    }
}