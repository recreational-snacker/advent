package advent2016;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RoomValidator {

//    public String calculateRoomHash(RoomDesignator room) {
//        final StringBuilder hash = new StringBuilder();
//        Stream<Character> chStream = room.getRoomLetters().chars().filter(c -> c != '-').mapToObj(c -> (char) c);
//        final Map<Character, Long> collect = chStream.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
//        collect.entrySet().stream()
//                .sorted(Map.Entry.<Character, Long>comparingByKey())
//                .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
//                .limit(5)
//                .forEach(set -> hash.append(set.getKey()));
//
//        return hash.toString();
//    }
//
//    public boolean isRoomValid(RoomDesignator roomDesignator) {
//        return roomDesignator.getHash().equalsIgnoreCase(calculateRoomHash(roomDesignator));
//    }
}
