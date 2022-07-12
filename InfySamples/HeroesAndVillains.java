package InfySamples;

public class HeroesAndVillains {
    public static int removeVillains(int N, int M, int H, int[] villains) {
        int count = 0;
        int villHealth = 0; // To store total health of villains
        int heroHealth = M * H; // To store total health of heroes

        // Calculating total health of all villains
        for (int villain: villains) {
            villHealth += villain;
        }

        // We need to remove villains worth this much health
        int toRemove = villHealth - heroHealth;
        if (toRemove > 0) {
            // While the villains worth the toRemove health are not removed...
            while (toRemove != 0) {
                // ... remove the villains from beginning and count them
                toRemove -= villains[count++];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] villains = {1, 2, 3, 1, 1};
        int N = 5, M = 3, H = 3;

        // int[] villains = {3, 1, 3, 3};
        // int N = 4, M = 4, H = 3;

        System.out.println(removeVillains(N, M, H, villains));
    }
}
