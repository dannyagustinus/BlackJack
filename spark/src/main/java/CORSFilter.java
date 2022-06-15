import java.util.*;
import spark.Filter;
import spark.Spark;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The CORSFilter disables browser-side Cross-Origin Request security features,
 * to allow the React application (with origin localhost:3000) to make requests
 * of the Spark server (with origin localhost:4567) without them being rejected.
 */
public class CORSFilter {
  // Contains all the headers that need to be added
  private final HashMap<String, String> corsHeaders = new HashMap<>();

  // Prepares the filter to be applied to the Spark system by initialized the headers
  // that need to be used.
  public CORSFilter() {
    corsHeaders.put("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
    corsHeaders.put("Access-Control-Allow-Origin", "*");
    corsHeaders.put("Access-Control-Allow-Headers",
            "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");
    corsHeaders.put("Access-Control-Allow-Credentials", "true");
  }

  public void apply() {
    Filter filter = (request, response) -> corsHeaders.forEach(response::header);
    Spark.afterAfter(filter); // Applies this filter even if there's a halt() or exception.
    //
    Logger logger = LoggerFactory.getLogger("CampusPaths Server");
    logger.info("Listening on: http://localhost:" + Spark.port());
  }
}
