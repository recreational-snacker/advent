package advent2016;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Deesha Singh on 2016/12/14.
 */
public class AdventDay13Test {

    @Test
    public void testDetermineIfWallOrOpen() {
        AdventDay13.isOpenSpace(1, 1, 10);
    }

    @Test
    public void testRoomCreation() {
        AdventDay13.createRoom(10, 10, 7, 7, 4);
    }

    @Test
    public void testRoomCreationSolution() {
        AdventDay13.createRoom(1358, 32, 40, 31, 39);
    }

}