package hanoiTower;

public class HanoiTower {
    public static void main(String[] args) {
        int numRings = 3;
        moveRing('A', 'B', 'C', numRings);
    }

    public static void moveRing(char a, char b, char c, int numRings) {
        if (numRings < 1) return;

        moveRing(a, c, b, numRings - 1);

        System.out.printf("\nFrom %c to %c", a, b);

        moveRing(c, b, a, numRings - 1);
    }
}
