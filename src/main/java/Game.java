import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public Player ifRegistered(String name) {
        for (Player item : players) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        throw new NotRegisteredException("Игрока с именем " + name + " нет в списке зарегистрированных");
    }


    public int round(String playerName1, String playerName2) throws Exception {
        Player player1 = ifRegistered(playerName1);
        Player player2 = ifRegistered(playerName2);

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
