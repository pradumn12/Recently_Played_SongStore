package com.songPlayer;																																																													
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SongUtils {

	private final int capacity;
    private final Map<String, String> songUserMap;
    private final Queue<String> recentlyPlayedQueue;

    public SongUtils(int capacity) {
        this.capacity = capacity;
        this.songUserMap = new LinkedHashMap(capacity, 0.75f, true);
        this.recentlyPlayedQueue = new LinkedList();
    }

    public void addSong(String song, String user) {
        // If the store is full, remove the least recently played song
        if (songUserMap.size() == capacity) {
            String leastRecentlyPlayed = recentlyPlayedQueue.poll();
            songUserMap.remove(leastRecentlyPlayed);
        }

        // Add the new song-user pair to the map and queue
        songUserMap.put(song, user);
        recentlyPlayedQueue.offer(song);
    }

    public void printRecentlyPlayedSongs() {
        System.out.println(recentlyPlayedQueue);
    }
    
    
    public Queue<String> returnRecentlyPlayedSongs() {
    	Queue<String> returnValue = new LinkedList(recentlyPlayedQueue);
    	System.out.println("Return Value is: "+returnValue);
    	return returnValue;
    }
    
	public static void main(String[] args) {
		
		SongUtils store = new SongUtils(3);
        store.addSong("S1", "User1");
        store.addSong("S2", "User1");
        store.addSong("S3", "User1");
        store.printRecentlyPlayedSongs();
        
        store.addSong("S4", "User1");
        store.printRecentlyPlayedSongs();
        
        store.addSong("S2", "User1");
        store.printRecentlyPlayedSongs();
        
        store.addSong("S1", "User1");
        store.printRecentlyPlayedSongs();
	}

}
