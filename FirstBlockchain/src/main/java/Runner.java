import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Runner {
    // Create an ArrayList to store the blocks of the blockchain
    public static ArrayList<Block> blockchain = new ArrayList<Block>();

    public static void main(String[] args) {
// Add the first block to the blockchain
        blockchain.add(new Block("The first block", "0"));
// Add the second block to the blockchain
        blockchain.add(new Block("The second block", blockchain.get(blockchain.size() - 1).hash));
// Add the third block to the blockchain
        blockchain.add(new Block("The third block", blockchain.get(blockchain.size() - 1).hash));

// Convert the blockchain to JSON format with pretty printing
        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        // Print the JSON representation of the blockchain
        System.out.println(blockchainJson);

    }

    // check the hash variable is actually equal to
    // the calculated hash, and the previous
    // block’s hash is equal to the previousHash variable.
    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        //loop through blockchain to check hashes
        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);
            //compare registered hash and calculated hash:
            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("current hashes not equal");
                return false;
            }
            //compare previous hash and registered previous hash
            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("previous hashes not equal");
                return false;
            }


        }
        return true;
    }

}
