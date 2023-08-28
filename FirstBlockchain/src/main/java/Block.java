import java.util.Date;
public class Block {

    public String hash;
    public String previousHash;
    public String data;

    private long timeStamp;


    public Block (String data, String previousHash){
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash(); //make sure to do this after setting other values
    }

    public String calculateHash(){
        String calculatedHash = StringUtil.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        data
        );
        return calculatedHash;
    }
}
//sha256 - cryptographic function that produces
// a 256 bits or 64 hexadecimal characters output
// regardless of input size
//cannot reverse engineer the original input