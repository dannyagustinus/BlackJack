import Internal.Entities.Card;
import Internal.Usecase.Game;
import com.google.gson.Gson;
import spark.Spark;

import java.util.Arrays;
import java.util.List;

public class SparkServer {
  public static void main(String[] args) {
    CORSFilter corsFilter = new CORSFilter();
    corsFilter.apply();

    Game game = new Game();

    Spark.get("/dealer-hands", (request, response) -> {
      List<Card> hand = game.getDealerHand();

      Gson gson = new Gson();
      return gson.toJson(hand);
    });

    Spark.get("/players-hands", (request, response) -> {
      List<List<Card>> hand = game.getPlayersHand();

      Gson gson = new Gson();
      return gson.toJson(hand);
    });

    Spark.get("/process-round", (request, response) -> {
      String query = request.queryParams("choices");
      if (query == null || query.equals("")) {
        Spark.halt(400, "invalid query");
      }

      String[] choices = query.split("-");

      List<Integer> res = game.processRound(Arrays.asList(choices));

      Gson gson = new Gson();
      return gson.toJson(res);
    });
  }
}
