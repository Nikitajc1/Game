import java.lang.management.PlatformLoggingMXBean;
import java.util.HashMap;

public class Game {

    private HashMap<Player, String> players = new HashMap<>();

    public void register(Player player) {
        players.put(player, player.getName());
    }

    public Player findByName(String name) {
        for (Player item : players.keySet()) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        throw new NotRegisteredException("Игрока с именем " + name + " нет в списке зарегистрированных");
    }


    public int round(String playerName1, String playerName2) throws Exception {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else {
            return 0;
        }
    }

    public HashMap<Player, String> findAll() {
        HashMap<Player, String> player = new HashMap<>();
        for (Player key : players.keySet()) {
            String value = players.get(key);
            player.put(key, value);
        }
        return player;
    }

}
