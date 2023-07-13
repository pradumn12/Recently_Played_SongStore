package com.songPlayer;
import static org.junit.Assert.assertEquals;
import java.util.Queue;
import org.junit.Before;
import org.junit.Test;

public class SongUtilsTest {
	
	 private SongUtils store;

	    @Before
	    public void setup() {
	        store = new SongUtils(3);
	    }
	
	@Test
	public void testRecentlyPlayedSongs() {
		
        store.addSong("S1", "User1");
        store.addSong("S2", "User1");
        store.addSong("S3", "User1");

        Queue<String> recentlyPlayed = store.returnRecentlyPlayedSongs();
        assertEquals(queueToString(recentlyPlayed), "S1,S2,S3");
        
        store.addSong("S4", "User1");

        recentlyPlayed = store.returnRecentlyPlayedSongs();
        assertEquals(queueToString(recentlyPlayed), "S2,S3,S4");
        
        store.addSong("S2", "User1");

        recentlyPlayed = store.returnRecentlyPlayedSongs();
        assertEquals(queueToString(recentlyPlayed), "S3,S4,S2");
        
		
	}
	
	private String queueToString(Queue<String> queue) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : queue) {
            stringBuilder.append(str).append(",");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1); // Remove the trailing comma
        }
        return stringBuilder.toString();
    }

}
