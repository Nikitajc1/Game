import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
//        List<Player> item = new ArrayList<>();
//        int index = 0;
//        for (Player name : players) {
//            name = item.get(0);
//            index++;
//        }
////        for (int i = 0; i < players.size(); i++) {
////            item.get(0) = players.get(i);
////        }
////        item.get(0) = player;
//        players = item;
    }

    public Player findByName(String name) {
        for (Player item : players) {
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

    public List<Player> findAll() {
        return players;
    }
}
