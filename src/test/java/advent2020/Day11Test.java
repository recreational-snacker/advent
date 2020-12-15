package advent2020;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Day11Test {

    private String sample = "L.LL.LL.LL\n" +
            "LLLLLLL.LL\n" +
            "L.L.L..L..\n" +
            "LLLL.LL.LL\n" +
            "L.LL.LL.LL\n" +
            "L.LLLLL.LL\n" +
            "..L.L.....\n" +
            "LLLLLLLLLL\n" +
            "L.LLLLLL.L\n" +
            "L.LLLLL.LL";

    private Map<String, SeatState> splitInputIntoMap(String input) {
        Map<String, SeatState> seats = new HashMap<>();
        String[] splitString = input.split("\n");
        for (int row = 0; row < splitString.length; row++) {
            String[] seatRow = splitString[row].split("");
            for (int col = 0; col < seatRow.length; col++) {
                seats.put(row+","+col, SeatState.findForCode(seatRow[col]));
            }
        }
        return seats;
    }

    private int sol(String input, int occ) {
        Map<String, SeatState> seats = splitInputIntoMap(input);
        Map<String, SeatState> currentSeats = splitInputIntoMap(input);
        boolean changes = true;
        while (changes) {
            changes = processSeatMap(occ, input, seats, currentSeats);
            seats = new HashMap<>(currentSeats);
        }
        return countSeats(SeatState.OCCUPIED, seats);
    }

    private int countSeats(SeatState seatState, Map<String, SeatState> seats) {
        AtomicInteger seatCount = new AtomicInteger();
        seats.forEach((k,v) -> {
            if (v.equals(seatState)) {
                seatCount.getAndIncrement();
            }
        });
        return seatCount.get();
    }

    private boolean processSeatMap(int occ, String input, Map<String, SeatState> seats, Map<String, SeatState> currentSeats) {
        boolean changes = false;
        for (int row = 0; row < findRowLength(input); row++) {
            for (int col = 0; col < findColLength(input); col++) {
                String currentSeat = row+","+col;
                SeatState currentSeatState = seats.get(currentSeat);
                if (currentSeatState.equals(SeatState.FLOOR)) {
                    continue;

                }
                if (currentSeatState.equals(SeatState.UNOCCUPIED)) {
                    if (surroundingSeatsAreUnoccupied(row, col, seats, currentSeat)) {
                        currentSeats.put(currentSeat, SeatState.OCCUPIED);
                        changes = true;
                    }
                }
                if (currentSeatState.equals(SeatState.OCCUPIED)) {
                    if (fourSurroundingSeatsAreOccupied(occ, row, col, seats, currentSeat)) {
                        currentSeats.put(currentSeat, SeatState.UNOCCUPIED);
                        changes = true;
                    }
                }
            }
        }
        return changes;
    }

    private int findRowLength(String input) {
        String[] splitString = input.split("\n");
        return splitString.length;
    }

    private int findColLength(String input) {
        String[] row = input.split("\n");
        String[] splitString = row[0].split("");
        return splitString.length;
    }

    private boolean fourSurroundingSeatsAreOccupied(int occ, int row, int col, Map<String, SeatState> seats, String currentSeat) {
        int seatCount = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int checkRow = row + i;
                int checkCol = col + j;
                String key = checkRow + "," + checkCol;
                if (seats.containsKey(key) && !key.equalsIgnoreCase(currentSeat)) {
                    SeatState ss = seats.get(key);
                    if (ss.equals(SeatState.OCCUPIED)) {
                        seatCount++;
                    }
                }
            }
        }
        return seatCount>=occ;
    }

    private boolean surroundingSeatsAreUnoccupied(int row, int col, Map<String, SeatState> seats, String currentSeat) {
        boolean valid = true;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int checkRow = row + i;
                int checkCol = col + j;
                String key = checkRow + "," + checkCol;
                if (seats.containsKey(key) && !key.equalsIgnoreCase(currentSeat)) {
                    SeatState ss = seats.get(key);
                    if (ss.equals(SeatState.OCCUPIED)) {
                        valid = false;
                    }
                }
            }
        }
        return valid;
    }

    private int sol2(String input, int occ) {
        Map<String, SeatState> seats = splitInputIntoMap(input);
        Map<String, SeatState> currentSeats = splitInputIntoMap(input);
        boolean changes = true;
        int count = 1;
        while (changes) {
            System.out.println("Count: "+count);
            changes = processSeatMap2(occ, input, seats, currentSeats);
            seats = new HashMap<>(currentSeats);
            count++;
        }
        return countSeats(SeatState.OCCUPIED, seats);
    }

    private boolean processSeatMap2(int occ, String input, Map<String, SeatState> seats, Map<String, SeatState> currentSeats) {
        boolean changes = false;

        for (int row = 0; row < findRowLength(input); row++) {
            for (int col = 0; col < findColLength(input); col++) {
                String currentSeat = row+","+col;
                SeatState currentSeatState = seats.get(currentSeat);
                if (currentSeatState.equals(SeatState.FLOOR)) {
                    continue;
                }
                if (currentSeatState.equals(SeatState.UNOCCUPIED)) {
                    List<Boolean> check = surroundingSeatsState(row, col, seats, findRowLength(input), findColLength(input), SeatState.UNOCCUPIED);
                    if (!check.contains(false)) {
                        currentSeats.put(currentSeat, SeatState.OCCUPIED);
                        changes = true;
                    }
                }
                if (currentSeatState.equals(SeatState.OCCUPIED)) {
                    List<Boolean> check = surroundingSeatsState(row, col, seats, findRowLength(input), findColLength(input), SeatState.OCCUPIED);
                    if (countUnoccupiedChairs(check, occ)) {
                        currentSeats.put(currentSeat, SeatState.UNOCCUPIED);
                        changes = true;
                    }
                }
            }
        }
        return changes;
    }

    private Boolean countUnoccupiedChairs(List<Boolean> check, int occ) {
        if (check.size()<occ) {
            return false;
        }
        if (check.size() == occ && !check.contains(false)) {
            return true;
        }
        if (check.size()>occ) {
            int countTrue = 0;
            for (Boolean b : check) {
                if (b) {
                    countTrue++;
                }
            }
            return countTrue >= occ;
        }
        return false;
    }

    private List<Boolean> surroundingSeatsState(int row, int col, Map<String, SeatState> seats, int rowLength, int colLength, SeatState seatState) {
        List<Boolean> validUnoccupied = new ArrayList<>();
        for (int i = col+1; i < colLength; i++) {
            String key = row + "," + i;
            if (checkSeat(seats, validUnoccupied, key, seatState) != null) {
                break;
            }
        }
        for (int i = col-1; i >= 0; i--) {
            String key = row + "," + i;
            if (checkSeat(seats, validUnoccupied, key, seatState) != null) {
                break;
            }
        }
        for (int i = row+1; i < rowLength; i++) {
            String key = i + "," + col;
            if (checkSeat(seats, validUnoccupied, key, seatState) != null) {
                break;
            }
        }
        for (int i = row-1; i >= 0; i--) {
            String key = i + "," + col;
            if (checkSeat(seats, validUnoccupied, key, seatState) != null) {
                break;
            }
        }
        boolean check = true;
        int count = 1;
        while (check) {
            int diagRow = row + count;
            int diagCol = col + count;
            String key = diagRow + "," + diagCol;
            if (checkSeat(seats, validUnoccupied, key, seatState) != null) {
                check = false;
            }
            count++;
        }
        check = true;
        count = 1;
        while (check) {
            int diagRow = row - count;
            int diagCol = col + count;
            String key = diagRow + "," + diagCol;
            if (checkSeat(seats, validUnoccupied, key, seatState) != null) {
                check = false;
            }
            count++;
        }
        check = true;
        count = 1;
        while (check) {
            int diagRow = row - count;
            int diagCol = col - count;
            String key = diagRow + "," + diagCol;
            if (checkSeat(seats, validUnoccupied, key, seatState) != null) {
                check = false;
            }
            count++;
        }
        check = true;
        count = 1;
        while (check) {
            int diagRow = row + count;
            int diagCol = col - count;
            String key = diagRow + "," + diagCol;
            if (checkSeat(seats, validUnoccupied, key, seatState) != null) {
                check = false;
            }
            count++;
        }
        return validUnoccupied;
    }

    private Boolean checkSeat(Map<String, SeatState> seats, List<Boolean> validStates, String key, SeatState seatState) {
        if (seats.containsKey(key)) {
            SeatState ss = seats.get(key);
            if (ss.equals(SeatState.FLOOR)) {
                return null;
            }
            if (ss.equals(seatState)) {
                validStates.add(true);
                return true;
            } else {
                validStates.add(false);
                return false;
            }
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(sol2(input, 5));
    }

    private enum SeatState {
        OCCUPIED("#"),
        UNOCCUPIED("L"),
        FLOOR(".");

        SeatState(String seatState) {
            this.seatState = seatState;
        }

        private String seatState;

        public String getSeatState() {
            return seatState;
        }

        public static SeatState findForCode(String value) {
            for (SeatState ss : SeatState.values()) {
                if (ss.getSeatState().equals(value)) {
                    return ss;
                }
            }
            return null;
        }

    }

    private String input = "LLLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLLLL.LLLLLLLL..LLLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLL.LLLL.LLLLLLLLLLLLL.LLLLLLLLLLLLL.LLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLL.LLLL.LLLL.LLLLLLLL.LLLLLLLLLL.LLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLL.LLLL.LL.LLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLL.LLLLL.LLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLL.LLLLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLL.LLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLLL.LLLLLLLLLL\n" +
            "...L.L......L...L..L...L..LL.....L.....L..LLLL..L.LL......LL....L..L.L..L....L.LL....LL..L..L\n" +
            "LLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLL.LLLLLL.LLLL.LLLL.LLLLLLLLLLLLL.LLLLL.LLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLL.LLLL.LLLLLLLL.LLLL.LLLLL.LLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLL.LLL..LLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLL.LLLL.LLLLLLLL.LLLLLLLLLL.LLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLL.LLLLLLLLLLLLL.LLLL.LLLLL.LLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLL.LLLL.LLLLLLLL.LLLL.LLLLL.LLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLL.LLLLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLL..LLLLLLLLLLLLLLLLL.LLLLLLLL.LLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLLLLL.LLLLLLLLLLLLL\n" +
            "LLLL.LLLLL.LLLL.LLL.LLLLLLLLLLLLLL.LLLLLLLL.LLLL.LLLL.LLLLLLLL.LLLL.LLLLLLLLLLLLLL.LLLLLLLLLL\n" +
            ".....L.LLLL....LL..L...LLL.L.LL..LL.L........L....LL...L...L...L.LL....LL...L..L.....LL.L....\n" +
            "LLLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLL.LL.LLLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLL.LLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLL.LL.LLLLLLL\n" +
            "LLLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLL.LLLL..LLLLLLLLLLLL.LLLL.LLLLLLLLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLLLL.LLLLLLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLL.LLLL.LLLLLLLLLLLLL.LLLL.LLLLL.LLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLL..LLLLLLLL.LLLLLLLL.LLLLLLLL.LLLL.LLLL.LLLLLLLL.LLLLLLLLLL.LLLLL.LL.LLLLLLLLLL\n" +
            "...L......L....L....L......L.L.....L..L.L.L..L.L...LLL.....LLLL.L.......LL.LLL.L.LL....L.....\n" +
            "LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLL.LL.LLLLLLLLLLLLLLL.LLLLLLLL.LLLL.LLLLL.LLLLLLLL.L.LLLL.LLL\n" +
            "LLLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLL.LL.L.LLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLL.LLLL.LLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLLL\n" +
            "...LL..........L..LLLLL...L.L..........L........L.LL..L..L.LLL.L..L.L.....LL...LL....L..L.L..\n" +
            "LLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLL.LLLL\n" +
            "LLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLL..LLLLLL.LLLL.LLLLL.LLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLL.LLLLL.LLLLLLLL.LLLLLLLLLL\n" +
            "LLLL.LLLLL.LLLL.LLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLL.LLLLL.LLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLLL.LLLL.LLLLL.LLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLL.LLLLL.LLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLL.LLL.LLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLL.LLLL.LLLL.LLLLLLLL.LLLL.LLLLL..LLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLL..L.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLLL\n" +
            "..LLLL.LL....LLL..L...L..L..L.......L..L...L.L...L..LL.L.L.L.L...L...L.L.L.L.L......LL...L..L\n" +
            "LLLLLLLLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLL.LLLLLLLL.LLLL.LLLLL.LLLLL.LLLLLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLL.LLLL.LLLL.LLLLLLLLLLLLL.LLLLL.LLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLLLL.LLL.LLLLLLLL.L.LLLLLL.LLLL.LLLL.LLLLLLLL.LLLL.LLLLLL.LLLLLL..LLLLLL.LLL\n" +
            "..L...L...L...L..L....L...LL.L.L.L..LL...........LLL.L......L..L.....LL..L..LLL........L....L\n" +
            "LLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLL.LLLLLLLLLLLLL.LLLLLLLLLL.LLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLL.LLLLLLLLLL.LLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLL.LLLLLLLLLL.LLLLLLL.LLLLLLLL.LLLLLLLLLL.LLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLL.LLLLLLL.LLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLL.LL.LLLL.LLLLLLL.L.LLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLL.LLLL.LLLLLLLLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLL.LLLLLL.L.LLLL.LLLL.LLLLLLLLLLLLL.LLLLL.LLLLLLLL.LL.L.LLLLL\n" +
            "..L.L.LL....L....L..L....L.L...L..L..L.L.....L..L...L.LL.....L...............L..............L\n" +
            "LLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLLL.LLLL.LLLLL.LLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLL.LL.L.LLLL.LLL.LLLL.LLLLL.LL.LLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLL.LLLL.LL.L.LLLLLLLL.LLLL.LLLLLLLLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLL.LLLLLLLL.LLLL.LLLL.LLLLLLLL.LLLL.LLLLL.LLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLL.LL.LLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLLL.LLLL.LLLLL.LLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLL.LLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLLL.LLLLLLLLLL\n" +
            "L.L.....L.L.L.LL.L......LLL.....L.L.L........L....LL.......L....L.....L....LL..L...LLL......L\n" +
            "LLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLL.LLLL.LLLLLLLL.LLLL.LLLLL.LLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLL.LLLLLL.L.LLLL.LLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLLL.LLLLLL.LLLLLLLLLLLLLLLLLLLLLL.LLLL.LLLLLLLL.LLLL.LLLLLLLLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLL..LLL.LLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLL.LLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLL.LLLL.LLLL.LLLLLLLLLLLLL.LLLLL.LLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLL.LLLLL.LLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLL.LLLL.LLLL.LLLL.LLL.LLLL.LLLLLLLLLLLLLL.LLLLLLLLLL\n" +
            "...L...L.....L....L.L..........L..L.L..L..L..LL.L..L.......L.......L....L....L...LLL..L..L..L\n" +
            "LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLL.LLLLL.LLLLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLL.LLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLL.LLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLL.LLLLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLL.LLLLL.LLLLLLLLLLLLLLLLLLL\n" +
            "..LLL....L.LL....L..............LLL......LL.LLL.....LL..L.L..L........L......L...L.LL..LL..L.\n" +
            "LLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLL.LLLL.LLLLLLLL.LLLL.LLLLL.LLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLL.LLLLLLLL.LLL..LLLLLLLLLLLLLL.LLLLLLLLLL\n" +
            "L.LLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLL.LLLLLLLL.LLLL.LLLLL.LLLLLLLL.LLLLLLLLLL\n" +
            "LLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLL.LLLL.LLLLLLLLLLLLL.LLL...LLLLLLLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLLLLLLLL..LLLLLLLLLLLLLLLLLLLLL.LLLL.LLLLLLLL.LLLL.LLLLL.LLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLL.LLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLL.LLLL.LLL.LLLLL.LLLLLLLL.LLLLLLLLLLLLL.LLLL.LLLLLLLL.LLLLLLLLLL.LLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLL.LLLL.LLLLLLLLLLLLL.LLLLL.LLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLLL.LLLLLLLLLL\n" +
            "L...L.LL......L...LLLLLL.L.L.L...L.L..L..L.LL....L......LL..L...LLL....L...LL......L.........\n" +
            "LLLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLL.LLLL.LLLL.LLLLLLLLLLLLL.LLLLL.LLLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLL.LLL..LLLLLLLLL.LLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLL.LLLLLL.LLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLLLL.LLLLLLLLLLLLLL.LLLL\n" +
            "LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLLL.LLLLLLLLLL";

}