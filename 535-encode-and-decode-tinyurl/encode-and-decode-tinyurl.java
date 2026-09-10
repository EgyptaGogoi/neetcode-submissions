import java.util.UUID;

public class Codec {
    Map<String, String> hm = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String s = UUID.randomUUID().toString().replace("-","");
        hm.put(s, longUrl);
        return s;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return hm.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));