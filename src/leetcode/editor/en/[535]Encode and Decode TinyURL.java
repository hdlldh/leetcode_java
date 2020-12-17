//Note: This is a companion problem to the System Design problem: Design TinyURL. 
//
// TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk. 
//
// Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL. 
// Related Topics Hash Table Math

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
public class Codec {
    HashMap<Integer, String> map;
    int count;
    public Codec(){
        map = new HashMap<>();
        count = 0;
    }
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(count, longUrl);
        String shortUrl = "http://tinyurl.com/"+count;
        count++;
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int count = Integer.parseInt(shortUrl.replace("http://tinyurl.com/",""));
        return map.get(count);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
//leetcode submit region end(Prohibit modification and deletion)
