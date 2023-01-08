import java.util.HashMap;

public class Game {

    private final HashMap<String, Integer> players = new HashMap<>();

    private boolean ifAlreadyRegistered(Player player) throws Exception {
        if (players.containsKey(player.getName())) {
            throw new AlreadyRegisteredException("Игрок с именем " + player.getName() + " уже зарегистрирован. Придумайте новое имя");
        }
        return true;
    }

    public void register(Player player) throws Exception {
        ifAlreadyRegistered(player);
        players.put(player.getName(), player.getStrength());

    }

    public boolean searchInMap(String name) {

        if (players.containsKey(name)) {
            return true;
        }
        throw new NotRegisteredException("Игрока с именем " + name + " нет в списке зарегистрированных");
    }

    public int round(String playerName1, String playerName2) throws Exception {
        searchInMap(playerName1);
        searchInMap(playerName2);

        int strength1 = players.get(playerName1);
        int strength2 = players.get(playerName2);

        if (strength1 < strength2) {
            return 2;
        } else if (strength1 > strength2) {
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
