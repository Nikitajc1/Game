import java.util.HashMap;
import java.util.Set;

public class Game {

    private HashMap<String, Integer> players = new HashMap<>();

    private boolean ifAlreadyRegistered(Player player) {
        for (String name : players.keySet()) {
            if (player.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    public void register(Player player) {
        if (ifAlreadyRegistered(player)) {
            players.put(player.getName(), player.getStrength());
        } else {
            throw new AlreadyRegisteredException("Игрок с именем " + player.getName() + " уже зарегистрирован. Придумайте новое имя");
        }
    }

    public HashMap<String, Integer> ifRegistered(String name) {

        HashMap<String, Integer> player = new HashMap<>();

        if (players.containsKey(name)) {
            player.put(name, players.get(name));
            return player;
//        for (String item : players.keySet()) {
//            if (item.equals(name)) {
//                player.put(item, players.get(item));
//                Player getP1 = (Player)players.get();
//                return player;
//            }
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
