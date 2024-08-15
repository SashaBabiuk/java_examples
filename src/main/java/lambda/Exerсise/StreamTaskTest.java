package lambda.Exerсise;
import lambda.Exerсise.Model.*;

import java.time.LocalDate;
import java.util.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class StreamTaskTest {
    private static final List<UserDB> testUsers = List.of(
            new UserDB("A", "A", "A", "qwerty", "a@gmail.com", "Kyiv", "Ukraine", 1999),
            new UserDB("AB", "A", "B", "qwerty", "ab@gmail.com", "Lviv", "Ukraine", 2002),
            new UserDB("B", "B", "B", "qwerty", "b@gmail.com", "Kharkiv", "Ukraine", 1994),
            new UserDB("BA", "B", "A", "qwerty", "ba@gmail.com", "Sevastopol", "Ukraine", 2000),
            new UserDB("C", "C", "C", "qwerty", "c@gmail.com", "Warsaw", "Poland", 1999)
    );

    @Test
    public void userDBToUserDTO() {
        List<UserDTO> expectedUserDTOs = List.of(
                new UserDTO("A", "A", "A", "Kyiv", "Ukraine", 1999),
                new UserDTO("AB", "A", "B", "Lviv", "Ukraine", 2002),
                new UserDTO("B", "B", "B", "Kharkiv", "Ukraine", 1994),
                new UserDTO("BA", "B", "A", "Sevastopol", "Ukraine", 2000),
                new UserDTO("C", "C", "C", "Warsaw", "Poland", 1999)
        );

        List<UserDTO> actualUserDTOs = Main.userDBToUserDTO(testUsers);

        assertEquals(expectedUserDTOs, actualUserDTOs);
    }

    @Test
    public void findUsersByYear() {
        int year = 1999;
        List<UserDB> expectedUsers = List.of(
                new UserDB("A", "A", "A", "qwerty", "a@gmail.com", "Kyiv", "Ukraine", 1999),
                new UserDB("C", "C", "C", "qwerty", "c@gmail.com", "Warsaw", "Poland", 1999)
        );

        List<UserDB> actualUsers = Main.findUsersByYear(testUsers, year);

        assertEquals(expectedUsers, actualUsers);
    }

    @Test
    public void getAverageUsersAge() {
        int currentYear = LocalDate.now().getYear();
        double expectedAverage = (currentYear * 5 - 9994) / 5.0;

        double actualAverage = Main.getAverageUsersAge(testUsers);

        assertEquals(expectedAverage, actualAverage, 0.01);
    }

    @Test
    public void getAverageYear_shouldReturnNegativeOneForEmptyList() {
        List<UserDB> emptyList = Collections.emptyList();

        double actualAverage = Main.getAverageUsersAge(emptyList);

        assertEquals(-1, actualAverage, 0.01);
    }

    @Test
    public void groupUsersByCountry() {
        Map<String, List<UserDB>> expectedMap = new HashMap<>();
        expectedMap.put("Ukraine", List.of(
                new UserDB("A", "A", "A", "qwerty", "a@gmail.com", "Kyiv", "Ukraine", 1999),
                new UserDB("AB", "A", "B", "qwerty", "ab@gmail.com", "Lviv", "Ukraine", 2002),
                new UserDB("B", "B", "B", "qwerty", "b@gmail.com", "Kharkiv", "Ukraine", 1994),
                new UserDB("BA", "B", "A", "qwerty", "ba@gmail.com", "Sevastopol", "Ukraine", 2000)
        ));
        expectedMap.put("Poland", List.of(
                new UserDB("C", "C", "C", "qwerty", "c@gmail.com", "Warsaw", "Poland", 1999)
        ));

        Map<String, List<UserDB>> actualMap = Main.groupUsersByCountry(testUsers);

        assertEquals(expectedMap, actualMap);
    }

    @Test
    public void sortByLastNameAndReturnFirstThree() {
        List<UserDB> sortedUsers = Main.sortByLastNameAndReturnFirstThree(testUsers);

        assertEquals(3, sortedUsers.size());
        assertEquals("A", sortedUsers.get(0).getLastName());
        assertEquals("A", sortedUsers.get(1).getLastName());
        assertEquals("B", sortedUsers.get(2).getLastName());
    }

    @Test
    public void groupSortedLastNamesByYear() {
        Map<Integer, Set<String>> sortedLastNamesByYear = Main.groupSortedLastNamesByYear(testUsers);

        assertEquals(4, sortedLastNamesByYear.size());
        assertTrue(sortedLastNamesByYear.containsKey(1994));
        assertTrue(sortedLastNamesByYear.containsKey(1999));
        assertTrue(sortedLastNamesByYear.containsKey(2000));
        assertTrue(sortedLastNamesByYear.containsKey(2002));

        Set<String> lastNames1994 = sortedLastNamesByYear.get(1994);
        assertEquals(1, lastNames1994.size());
        assertTrue(lastNames1994.contains("B"));

        Set<String> lastNames1999 = sortedLastNamesByYear.get(1999);
        assertEquals(2, lastNames1999.size());
        assertTrue(lastNames1999.contains("A"));
        assertTrue(lastNames1999.contains("C"));

        Set<String> lastNames2000 = sortedLastNamesByYear.get(2000);
        assertEquals(1, lastNames2000.size());
        assertTrue(lastNames2000.contains("A"));

        Set<String> lastNames2002 = sortedLastNamesByYear.get(2002);
        assertEquals(1, lastNames2002.size());
        assertTrue(lastNames2002.contains("B"));
    }

    @Test
    public void sortByFirstNameAndLastName() {
        List<UserDB> sortedUsers = Main.sortByFirstNameAndLastName(testUsers);

        List<UserDB> expectedSortedUsers = List.of(
                new UserDB("A", "A", "A", "qwerty", "a@gmail.com", "Kyiv", "Ukraine", 1999),
                new UserDB("AB", "A", "B", "qwerty", "ab@gmail.com", "Lviv", "Ukraine", 2002),
                new UserDB("BA", "B", "A", "qwerty", "ba@gmail.com", "Sevastopol", "Ukraine", 2000),
                new UserDB("B", "B", "B", "qwerty", "b@gmail.com", "Kharkiv", "Ukraine", 1994),
                new UserDB("C", "C", "C", "qwerty", "c@gmail.com", "Warsaw", "Poland", 1999)
        );

        assertEquals(expectedSortedUsers, sortedUsers);
    }

    @Test
    public void isUserWithEmailExists() {
        assertTrue(Main.isUserWithEmailExists(testUsers, "ab@gmail.com"));

        assertFalse(Main.isUserWithEmailExists(testUsers, "xyz@gmail.com"));
    }

    @Test
    public void returnPageWithSize() {
        // Test first page with 2 elements
        List<UserDB> expectedPage1 = List.of(
                new UserDB("A", "A", "A", "qwerty", "a@gmail.com", "Kyiv", "Ukraine", 1999),
                new UserDB("AB", "A", "B", "qwerty", "ab@gmail.com", "Lviv", "Ukraine", 2002)
        );
        List<UserDB> actualPage1 = Main.returnPageWithSize(testUsers, 0, 2);
        assertEquals(expectedPage1, actualPage1);

        // Test second page with 2 elements
        List<UserDB> expectedPage2 = List.of(
                new UserDB("B", "B", "B", "qwerty", "b@gmail.com", "Kharkiv", "Ukraine", 1994),
                new UserDB("BA", "B", "A", "qwerty", "ba@gmail.com", "Sevastopol", "Ukraine", 2000)
        );
        List<UserDB> actualPage2 = Main.returnPageWithSize(testUsers, 1, 2);
        assertEquals(expectedPage2, actualPage2);

        // Test third page with 1 element (last element)
        List<UserDB> expectedPage3 = List.of(
                new UserDB("C", "C", "C", "qwerty", "c@gmail.com", "Warsaw", "Poland", 1999)
        );
        List<UserDB> actualPage3 = Main.returnPageWithSize(testUsers, 2, 2);
        assertEquals(expectedPage3, actualPage3);

        // Test empty page (no elements)
        List<UserDB> expectedPageEmpty = Collections.emptyList();
        List<UserDB> actualPageEmpty = Main.returnPageWithSize(testUsers, 3, 2);
        assertEquals(expectedPageEmpty, actualPageEmpty);
    }

    @Test
    public void getCharsFrequencyFromLastName() {
        Map<Character, Long> expectedFrequencyMap = Map.of(
                'B', 2L,
                'A', 2L,
                'C', 1L
        );

        Map<Character, Long> actualFrequencyMap = Main.getCharsFrequencyFromLastName(testUsers);

        assertEquals(expectedFrequencyMap.get('A'), actualFrequencyMap.get('A'));
        assertEquals(expectedFrequencyMap.get('B'), actualFrequencyMap.get('B'));
        assertEquals(expectedFrequencyMap.get('C'), actualFrequencyMap.get('C'));
    }
}