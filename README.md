#Recently Played SongStore

Recently Played SongStore is an in-memory store for recently played songs. It can accommodate N songs per user and has a fixed initial capacity. The store keeps track of song-user pairs and allows fetching the recently played songs based on the user.


### Prerequisites

- Java Development Kit (JDK) installed
## Usage/Examples
Create an instance of the SongUtils class:
java

SongUtils store = new SongUtils(3);

Replace 3 with the desired capacity for each user.

Add songs using the addSong method:
1->store.addSong("User1", "S1");
2->store.addSong("User1", "S2");
3->store.addSong("User1", "S3");


Retrieve recently played songs using the returnRecentlyPlayedSongs method:

Queue<String> returnValue = new LinkedList(recentlyPlayedQueue);
System.out.println("Return Value is: "+returnValue);
return returnValue;




## Running Tests

Junit

@Before to intitlaize before initiating the test

SongUtils store = new SongUtils(3);

@Test
testRecentlyPlayedSongs();

Add the songs and comapre the expected value with actual value using assertEquals to validate the functionality.