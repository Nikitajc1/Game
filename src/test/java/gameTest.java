import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.Platform;

import java.util.ArrayList;
import java.util.List;

public class gameTest {
    Game service = new Game();
    Player player1 = new Player(1, "Ivan", 6);
    Player player2 = new Player(2, "Olya", 8);
    Player player3 = new Player(3, "Masha", 3);
    Player player4 = new Player(4, "Misha", 8);
    Player player5 = new Player(5, "Oleg", 7);

    @Test
    public void registerTest() {
        service.register(player1);

        List<Player> expected = new ArrayList<>();
        expected.add(player1);

        List<Player> actual = service.findAll();

        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    public void findByNameIfExist() {
        service.register(player1);
        service.register(player2);
        service.register(player3);

        Player expected = player2;

        Player actual = service.ifRegistered("Olya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findByNameIfNotExist() {
        service.register(player1);
        service.register(player2);
        service.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            service.ifRegistered("O");
        });
    }

    @Test
    public void round1Test() throws Exception {
        service.register(player1);
        service.register(player2);
        service.register(player3);

        int expected = 2;
        int actual = service.round("Ivan", "Olya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void round2Test() throws Exception {
        service.register(player1);
        service.register(player2);
        service.register(player3);
        service.register(player4);
        service.register(player5);

        int expected = 1;
        int actual = service.round("Olya", "Masha");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void round3Test() throws Exception {
        service.register(player1);
        service.register(player2);
        service.register(player3);
        service.register(player4);
        service.register(player5);

        int expected = 0;
        int actual = service.round("Olya", "Misha");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void round4Test() throws Exception {
        service.register(player1);
        service.register(player2);
        service.register(player3);
        service.register(player4);
        service.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            service.round("Enga", "Olya");
        });
    }

    @Test
    public void round5Test() throws Exception {
        service.register(player1);
        service.register(player2);
        service.register(player3);
        service.register(player4);
        service.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            service.round("Olya", "Enga");
        });
    }

    @Test
    public void getIdTest() {
        service.register(player1);

        int expected = 1;
        int actual = player1.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setIdTest() {
        service.register(player1);
        player1.setId(7);

        int expected = 7;
        int actual = player1.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setNameTest() {
        service.register(player1);
        player1.setName("Qwarty");

        String expected = "Qwarty";
        String actual = player1.getName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setStrengthTest() {
        service.register(player1);
        player1.setStrength(7);

        int expected = 7;
        int actual = player1.getStrength();

        Assertions.assertEquals(expected, actual);
    }
}
