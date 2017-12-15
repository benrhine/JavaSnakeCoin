import com.benrhine.domain.GuavaBlock;
import com.benrhine.domain.JavaBlock;
import com.benrhine.service.SnakeCoinService;

import java.util.ArrayList;
import java.util.List;

/** =================================================================================================================
 * Simple Blockchain implementation written in Java. Current block hashing choice makes use of Google's Guava
 * library but I have included a pure Java hashing implementation as well. If you wish to try the pure Java hashing
 * comment out createGuavaBlockChain in main and un-comment createJavaBlockChain.
 *
 * To Execute this application
 *      ./gradlew build
 *      ./gradlew run
 * ================================================================================================================== */
public class App {
    private final static Integer numberOfBlocksToAdd = 20;

    public String getGreeting() {
        return "Welcome to Snake Coin. Now creating " + numberOfBlocksToAdd + " SnakeCoins";
    }

    private void createGuavaBlockChain() {
        SnakeCoinService snakeCoinService = new SnakeCoinService();
        List<GuavaBlock> blockChain = new ArrayList<>();
        blockChain.add(snakeCoinService.createGenesisGuavaBlock());
        GuavaBlock previousBlock = blockChain.get(0);

        System.out.println("Genesis Block has been added to the blockchain!\nGenesis Hash: " + blockChain.get(0).getHash() + "\n");

        for (int i = 0; i < numberOfBlocksToAdd; i++) {
            final GuavaBlock newBlock = snakeCoinService.nextGuavaBlock(previousBlock);
            blockChain.add(newBlock);
            previousBlock = newBlock;

            System.out.println("Block #" + newBlock.getIndex() + " has been added to the blockchain! ");
            System.out.println("Hash: " + newBlock.getHash() + "\n");
        }
    }

    private void createJavaBlockChain() {
        SnakeCoinService snakeCoinService = new SnakeCoinService();
        List<JavaBlock> blockChain = new ArrayList<>();
        blockChain.add(snakeCoinService.createGenesisJavaBlock());
        JavaBlock previousBlock = blockChain.get(0);

        System.out.println("Genesis Block has been added to the blockchain!\nGenesis Hash: " + blockChain.get(0).getHash() + "\n");

        for (int i = 0; i < numberOfBlocksToAdd; i++) {
            final JavaBlock newBlock = snakeCoinService.nextJavaBlock(previousBlock);
            blockChain.add(newBlock);
            previousBlock = newBlock;

            System.out.println("Block #" + newBlock.getIndex() + " has been added to the blockchain! ");
            System.out.println("Hash: " + newBlock.getHash() + "\n");
        }
    }

    public static void main(String[] args) {
        final App app = new App();
        System.out.println(app.getGreeting());

        /* Create block hashes using Guava library */
        app.createGuavaBlockChain();

        /* or */

        /* Create block hashes using pure Java (uncomment to use) */
        //app.createJavaBlockChain();
    }
}
