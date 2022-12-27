import java.lang.management.PlatformLoggingMXBean;
import java.util.HashMap;

public class Game {

    private HashMap<String, Integer> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getName(), player.getStrength());
    }

    public HashMap<String, Integer> ifRegistered(String name) {
        HashMap<String, Integer> player = new HashMap<>();

        for (String item : players.keySet()) {
            if (item.equals(name)) {
                player.put(item, players.get(item));
                return player;
            }
        }
        throw new NotRegisteredException("Игрока с именем " + name + " нет в списке зарегистрированных");
    }


    public int round(String playerName1, String playerName2) throws Exception {
        HashMap<String, Integer> player1 = ifRegistered(playerName1);
        HashMap<String, Integer> player2 = ifRegistered(playerName2);

        if (player1.get(playerName1) < player2.get(playerName2)) {
            return 2;
        } else if (player1.get(playerName1) > player2.get(playerName2)) {
            return 1;
        } else {
            return 0;
        }
    }

    public HashMap<String, Integer> findAll() {
        HashMap<String, Integer> player = new HashMap<>();
        for (String key : players.keySet()) {
            Integer value = players.get(key);
            player.put(key, value);
        }
        return player;
    }

}
