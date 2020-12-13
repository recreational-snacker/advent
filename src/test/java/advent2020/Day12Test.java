package advent2020;

import org.junit.Test;

public class Day12Test {

    private String sample = "F10\n" +
            "N3\n" +
            "F7\n" +
            "R90\n" +
            "F11";

    private String[] splitString(String input) {
        return input.split("\n");
    }

    private Integer findManhattanDistanceForOne(String input) {
        String[] splitString = splitString(input);
        int x = 0;
        int y = 0;
        Direction currentDir = Direction.EAST;

        for (String s : splitString) {
            String dir = s.substring(0, 1);
            int dist = Integer.parseInt(s.substring(1));

            if ("R".equals(dir)) {
                int times = Math.floorDiv(dist, 90);
                while (times>0) {
                    currentDir = currentDir.R;
                    times--;
                }
                continue;
            } else if ("L".equals(dir)) {
                int times = Math.floorDiv(dist, 90);
                while (times>0) {
                    currentDir = currentDir.L;
                    times--;
                }
                continue;
            } else if ("F".equals(dir)) {
                currentDir = currentDir.F;
                if (Direction.NORTH.equals(currentDir)) {
                    y += dist;
                } else if (Direction.SOUTH.equals(currentDir)) {
                    y -= dist;
                } else if (Direction.EAST.equals(currentDir)) {
                    x += dist;
                } else if (Direction.WEST.equals(currentDir)) {
                    x -= dist;
                }
                continue;
            }

            if ("N".equals(dir)) {
                y += dist;
            } else if ("S".equals(dir)) {
                y -= dist;
            } else if ("E".equals(dir)) {
                x += dist;
            } else if ("W".equals(dir)) {
                x -= dist;
            }
        }
        return Math.abs(x) + Math.abs(y);
    }

    private Integer findManhattanDistanceForTow(String input) {
        String[] splitString = splitString(input);

        int wx = 10;
        int wy = 1;
        int sx = 0;
        int sy = 0;

        Waypoint waypoint = new Waypoint(Direction.EAST, Direction.NORTH);

        for (String s : splitString) {
            String dir = s.substring(0, 1);
            int dist = Integer.parseInt(s.substring(1));

            if ("R".equals(dir) || "L".equals(dir)) {
                int times = Math.floorDiv(dist, 90);

                Direction waypointDir = Direction.findDirectionForWaypoint(waypoint);
                while (times>0) {
                    if ("R".equals(dir)) {
                        waypointDir = waypointDir.CLOCK;
                    } else {
                        waypointDir = waypointDir.ANTICLOCK;
                    }
                    int oldwx = wx;
                    wx = wy;
                    wy = oldwx;
                    times--;
                }
                Direction wpX = Direction.findDirection(waypointDir.getDir().substring(1));
                Direction wpY = Direction.findDirection(waypointDir.getDir().substring(0,1));
                Waypoint changeWaypoint = new Waypoint(wpX, wpY);
                if (changeWaypoint.getX() != waypoint.getX()) {
                    wx = -wx;
                }
                if (changeWaypoint.getY() != waypoint.getY()) {
                    wy = -wy;
                }
            } else if ("F".equals(dir)) {
                sx += (dist * wx);
                sy += (dist * wy);
            } else if ("N".equals(dir)) {
                wy += dist;
            } else if ("S".equals(dir)) {
                wy -= dist;
            } else if ("E".equals(dir)) {
                wx += dist;
            } else if ("W".equals(dir)) {
                wx -= dist;
            }
        }
        return Math.abs(sx) + Math.abs(sy);
    }

    @Test
    public void test() {
        System.out.println(findManhattanDistanceForOne(input));
        System.out.println(findManhattanDistanceForTow(input));
    }

    class Waypoint {
        private Direction x;
        private Direction y;

        public Waypoint(Direction x, Direction y) {
            this.x = x;
            this.y = y;
        }

        public Direction getX() {
            return x;
        }

        public void setX(Direction x) {
            this.x = x;
        }

        public Direction getY() {
            return y;
        }

        public void setY(Direction y) {
            this.y = y;
        }
        public void swapX() {

        }
    }

    enum Direction {
        NORTH("N"), SOUTH("S"), EAST("E"), WEST("W"), NORTHEAST("NE"), NORTHWEST("NW"), SOUTHEAST("SE"), SOUTHWEST("SW");
        String dir;

        public String getDir() {
            return dir;
        }

        Direction(String dir) {
            this.dir = dir;
        }

        Direction L, R, F, CLOCK, ANTICLOCK, OPP;

        static {
            NORTH.L = WEST;
            NORTH.R = EAST;
            NORTH.F = NORTH;
            NORTH.OPP = SOUTH;

            SOUTH.L = EAST;
            SOUTH.R = WEST;
            SOUTH.F = SOUTH;
            SOUTH.OPP = NORTH;

            EAST.R = SOUTH;
            EAST.L = NORTH;
            EAST.F = EAST;
            EAST.OPP = WEST;

            WEST.R = NORTH;
            WEST.L = SOUTH;
            WEST.F = WEST;
            WEST.OPP = EAST;

            NORTHEAST.CLOCK = SOUTHEAST;
            NORTHEAST.ANTICLOCK = NORTHWEST;

            NORTHWEST.CLOCK = NORTHEAST;
            NORTHWEST.ANTICLOCK = SOUTHWEST;

            SOUTHEAST.CLOCK = SOUTHWEST;
            SOUTHEAST.ANTICLOCK = NORTHEAST;

            SOUTHWEST.CLOCK = NORTHWEST;
            SOUTHWEST.ANTICLOCK = SOUTHEAST;
        }

        public static Direction findDirectionForWaypoint(Waypoint waypoint) {
            String d = waypoint.getY().getDir()+waypoint.getX().getDir();
            return findDirection(d);
        }

        public static Direction findDirection(String value) {
            for (Direction direction : Direction.values()) {
                if (direction.getDir().equals(value)) {
                    return direction;
                }
            }
            return null;
        }
    }

    private String input = "S2\n" +
            "W5\n" +
            "F20\n" +
            "E3\n" +
            "S5\n" +
            "R90\n" +
            "W5\n" +
            "F48\n" +
            "R180\n" +
            "E3\n" +
            "S3\n" +
            "E5\n" +
            "S3\n" +
            "F83\n" +
            "S1\n" +
            "W5\n" +
            "F81\n" +
            "W3\n" +
            "R90\n" +
            "F88\n" +
            "S2\n" +
            "R90\n" +
            "E2\n" +
            "L90\n" +
            "W4\n" +
            "F77\n" +
            "E1\n" +
            "R90\n" +
            "S4\n" +
            "E2\n" +
            "F89\n" +
            "N2\n" +
            "L90\n" +
            "N2\n" +
            "N2\n" +
            "E3\n" +
            "L180\n" +
            "N1\n" +
            "F82\n" +
            "R90\n" +
            "S3\n" +
            "F64\n" +
            "W1\n" +
            "R180\n" +
            "S2\n" +
            "R180\n" +
            "F28\n" +
            "L180\n" +
            "S3\n" +
            "F100\n" +
            "E1\n" +
            "S4\n" +
            "S5\n" +
            "R90\n" +
            "F3\n" +
            "W5\n" +
            "N4\n" +
            "F9\n" +
            "N5\n" +
            "E4\n" +
            "R90\n" +
            "F83\n" +
            "L180\n" +
            "W3\n" +
            "N5\n" +
            "W2\n" +
            "R180\n" +
            "W1\n" +
            "S4\n" +
            "L90\n" +
            "S5\n" +
            "R90\n" +
            "R90\n" +
            "F36\n" +
            "L180\n" +
            "W1\n" +
            "F88\n" +
            "E3\n" +
            "R90\n" +
            "F13\n" +
            "W1\n" +
            "F13\n" +
            "W4\n" +
            "R90\n" +
            "E3\n" +
            "F98\n" +
            "S4\n" +
            "E5\n" +
            "R90\n" +
            "F77\n" +
            "E5\n" +
            "L180\n" +
            "N5\n" +
            "R90\n" +
            "E1\n" +
            "F70\n" +
            "L180\n" +
            "F54\n" +
            "E5\n" +
            "F9\n" +
            "L180\n" +
            "N3\n" +
            "F77\n" +
            "E2\n" +
            "F81\n" +
            "E2\n" +
            "S1\n" +
            "F41\n" +
            "L90\n" +
            "F32\n" +
            "S3\n" +
            "F66\n" +
            "N2\n" +
            "E4\n" +
            "R90\n" +
            "F80\n" +
            "R90\n" +
            "W1\n" +
            "R90\n" +
            "S3\n" +
            "F65\n" +
            "S4\n" +
            "R90\n" +
            "W4\n" +
            "S4\n" +
            "R90\n" +
            "W4\n" +
            "S2\n" +
            "E1\n" +
            "F44\n" +
            "R90\n" +
            "F53\n" +
            "E3\n" +
            "F67\n" +
            "S5\n" +
            "L90\n" +
            "R90\n" +
            "W2\n" +
            "S2\n" +
            "E3\n" +
            "N5\n" +
            "F97\n" +
            "N3\n" +
            "E1\n" +
            "R90\n" +
            "W4\n" +
            "N5\n" +
            "S4\n" +
            "F38\n" +
            "N5\n" +
            "N1\n" +
            "W4\n" +
            "S3\n" +
            "E1\n" +
            "S3\n" +
            "F87\n" +
            "E1\n" +
            "R90\n" +
            "E2\n" +
            "L180\n" +
            "S1\n" +
            "L90\n" +
            "F29\n" +
            "R90\n" +
            "S2\n" +
            "F95\n" +
            "N2\n" +
            "E5\n" +
            "F24\n" +
            "W1\n" +
            "F71\n" +
            "E3\n" +
            "L90\n" +
            "F16\n" +
            "L90\n" +
            "S5\n" +
            "L90\n" +
            "W1\n" +
            "F95\n" +
            "L90\n" +
            "W2\n" +
            "F97\n" +
            "E4\n" +
            "R90\n" +
            "N5\n" +
            "F77\n" +
            "E2\n" +
            "L90\n" +
            "F71\n" +
            "L90\n" +
            "W2\n" +
            "R90\n" +
            "F75\n" +
            "E1\n" +
            "S1\n" +
            "F28\n" +
            "F86\n" +
            "R90\n" +
            "E3\n" +
            "F9\n" +
            "N2\n" +
            "W4\n" +
            "S1\n" +
            "L90\n" +
            "F10\n" +
            "W4\n" +
            "L90\n" +
            "S5\n" +
            "E1\n" +
            "L90\n" +
            "W2\n" +
            "S3\n" +
            "F41\n" +
            "L90\n" +
            "S5\n" +
            "F73\n" +
            "L90\n" +
            "S4\n" +
            "F80\n" +
            "W4\n" +
            "R180\n" +
            "S4\n" +
            "E3\n" +
            "F89\n" +
            "E5\n" +
            "N5\n" +
            "L90\n" +
            "F66\n" +
            "N4\n" +
            "W1\n" +
            "F93\n" +
            "W1\n" +
            "F27\n" +
            "F68\n" +
            "N4\n" +
            "F23\n" +
            "L90\n" +
            "F14\n" +
            "S3\n" +
            "F74\n" +
            "N2\n" +
            "E2\n" +
            "R90\n" +
            "S4\n" +
            "F85\n" +
            "N2\n" +
            "L180\n" +
            "L180\n" +
            "F55\n" +
            "S5\n" +
            "E5\n" +
            "F42\n" +
            "N2\n" +
            "R90\n" +
            "F53\n" +
            "S4\n" +
            "F70\n" +
            "E2\n" +
            "F73\n" +
            "S4\n" +
            "F71\n" +
            "L90\n" +
            "E1\n" +
            "S3\n" +
            "E5\n" +
            "N3\n" +
            "E2\n" +
            "N5\n" +
            "L270\n" +
            "F69\n" +
            "E5\n" +
            "F30\n" +
            "N1\n" +
            "R90\n" +
            "N4\n" +
            "F15\n" +
            "E4\n" +
            "R180\n" +
            "F12\n" +
            "E2\n" +
            "F95\n" +
            "E2\n" +
            "S4\n" +
            "F13\n" +
            "S1\n" +
            "E1\n" +
            "N4\n" +
            "E3\n" +
            "L270\n" +
            "E4\n" +
            "S5\n" +
            "E3\n" +
            "N2\n" +
            "R180\n" +
            "S2\n" +
            "W2\n" +
            "L90\n" +
            "S3\n" +
            "W4\n" +
            "R90\n" +
            "E1\n" +
            "L180\n" +
            "W5\n" +
            "F23\n" +
            "E5\n" +
            "F67\n" +
            "R90\n" +
            "N2\n" +
            "W4\n" +
            "L90\n" +
            "S1\n" +
            "L90\n" +
            "F17\n" +
            "W2\n" +
            "F80\n" +
            "E1\n" +
            "F13\n" +
            "S2\n" +
            "E3\n" +
            "S4\n" +
            "F46\n" +
            "F70\n" +
            "R180\n" +
            "E3\n" +
            "L90\n" +
            "E4\n" +
            "L90\n" +
            "S3\n" +
            "F31\n" +
            "W5\n" +
            "R90\n" +
            "F21\n" +
            "S5\n" +
            "L90\n" +
            "F12\n" +
            "L90\n" +
            "F70\n" +
            "S1\n" +
            "R180\n" +
            "W5\n" +
            "F14\n" +
            "S5\n" +
            "W5\n" +
            "S1\n" +
            "F56\n" +
            "L90\n" +
            "F43\n" +
            "S4\n" +
            "N4\n" +
            "E1\n" +
            "R180\n" +
            "S1\n" +
            "R90\n" +
            "E3\n" +
            "N4\n" +
            "R90\n" +
            "S2\n" +
            "E5\n" +
            "S4\n" +
            "W4\n" +
            "R90\n" +
            "F88\n" +
            "S4\n" +
            "R90\n" +
            "F79\n" +
            "L90\n" +
            "N2\n" +
            "E3\n" +
            "F74\n" +
            "L90\n" +
            "F72\n" +
            "W1\n" +
            "N3\n" +
            "R90\n" +
            "E2\n" +
            "F38\n" +
            "W3\n" +
            "L90\n" +
            "E3\n" +
            "N2\n" +
            "R90\n" +
            "E2\n" +
            "L90\n" +
            "N3\n" +
            "E1\n" +
            "F96\n" +
            "E3\n" +
            "S4\n" +
            "R180\n" +
            "F28\n" +
            "S2\n" +
            "F93\n" +
            "L270\n" +
            "N3\n" +
            "R90\n" +
            "N2\n" +
            "E4\n" +
            "S1\n" +
            "F47\n" +
            "L270\n" +
            "F9\n" +
            "N2\n" +
            "F80\n" +
            "S4\n" +
            "L180\n" +
            "N5\n" +
            "W2\n" +
            "L90\n" +
            "W4\n" +
            "N5\n" +
            "L90\n" +
            "F82\n" +
            "R90\n" +
            "N3\n" +
            "F4\n" +
            "R90\n" +
            "F96\n" +
            "W5\n" +
            "R90\n" +
            "F28\n" +
            "W2\n" +
            "S2\n" +
            "F16\n" +
            "S4\n" +
            "R90\n" +
            "F9\n" +
            "N5\n" +
            "W4\n" +
            "F78\n" +
            "E3\n" +
            "F84\n" +
            "L90\n" +
            "F42\n" +
            "W2\n" +
            "F43\n" +
            "W4\n" +
            "L90\n" +
            "F95\n" +
            "E1\n" +
            "R90\n" +
            "F59\n" +
            "L90\n" +
            "F82\n" +
            "W1\n" +
            "F17\n" +
            "S4\n" +
            "R180\n" +
            "F91\n" +
            "L180\n" +
            "N1\n" +
            "R90\n" +
            "N3\n" +
            "F57\n" +
            "L90\n" +
            "F90\n" +
            "N3\n" +
            "R90\n" +
            "F98\n" +
            "N5\n" +
            "R90\n" +
            "N2\n" +
            "R90\n" +
            "F4\n" +
            "S2\n" +
            "F80\n" +
            "S2\n" +
            "N2\n" +
            "W4\n" +
            "L90\n" +
            "E2\n" +
            "F67\n" +
            "R90\n" +
            "W4\n" +
            "L180\n" +
            "F22\n" +
            "L90\n" +
            "S3\n" +
            "F9\n" +
            "N5\n" +
            "W2\n" +
            "L180\n" +
            "S3\n" +
            "F23\n" +
            "S4\n" +
            "W4\n" +
            "F90\n" +
            "S2\n" +
            "F32\n" +
            "S3\n" +
            "E5\n" +
            "R90\n" +
            "E1\n" +
            "F64\n" +
            "R180\n" +
            "F17\n" +
            "E3\n" +
            "R90\n" +
            "N2\n" +
            "E1\n" +
            "F90\n" +
            "W3\n" +
            "N5\n" +
            "F19\n" +
            "S5\n" +
            "E4\n" +
            "N5\n" +
            "R90\n" +
            "W1\n" +
            "F18\n" +
            "R180\n" +
            "E2\n" +
            "R90\n" +
            "F76\n" +
            "L90\n" +
            "N2\n" +
            "F96\n" +
            "F38\n" +
            "R180\n" +
            "F94\n" +
            "S4\n" +
            "W4\n" +
            "S4\n" +
            "F63\n" +
            "E4\n" +
            "L90\n" +
            "F69\n" +
            "S2\n" +
            "W3\n" +
            "N1\n" +
            "L270\n" +
            "N1\n" +
            "L90\n" +
            "N4\n" +
            "R90\n" +
            "E5\n" +
            "F67\n" +
            "F85\n" +
            "S1\n" +
            "F2\n" +
            "F68\n" +
            "W2\n" +
            "R90\n" +
            "E4\n" +
            "R90\n" +
            "S3\n" +
            "W4\n" +
            "S2\n" +
            "N5\n" +
            "F13\n" +
            "R180\n" +
            "W1\n" +
            "F31\n" +
            "S1\n" +
            "F23\n" +
            "S1\n" +
            "R90\n" +
            "F86\n" +
            "L90\n" +
            "N5\n" +
            "W3\n" +
            "F47\n" +
            "R90\n" +
            "R270\n" +
            "S1\n" +
            "L90\n" +
            "S1\n" +
            "F40\n" +
            "N4\n" +
            "R180\n" +
            "N1\n" +
            "L180\n" +
            "W3\n" +
            "S1\n" +
            "W5\n" +
            "L90\n" +
            "W5\n" +
            "F41\n" +
            "S4\n" +
            "E2\n" +
            "N5\n" +
            "E4\n" +
            "N1\n" +
            "F97\n" +
            "L90\n" +
            "F62\n" +
            "N5\n" +
            "R90\n" +
            "F98\n" +
            "R180\n" +
            "S5\n" +
            "L270\n" +
            "N5\n" +
            "W5\n" +
            "N4\n" +
            "E3\n" +
            "F38\n" +
            "L90\n" +
            "S2\n" +
            "F79\n" +
            "R270\n" +
            "E1\n" +
            "F14\n" +
            "W1\n" +
            "F38\n" +
            "E3\n" +
            "L180\n" +
            "N4\n" +
            "L90\n" +
            "S5\n" +
            "F90\n" +
            "S1\n" +
            "F7\n" +
            "N1\n" +
            "F11\n" +
            "W4\n" +
            "R180\n" +
            "F73\n" +
            "L90\n" +
            "F54\n" +
            "F25\n" +
            "W5\n" +
            "S3\n" +
            "F39\n" +
            "E2\n" +
            "F37\n" +
            "E2\n" +
            "S4\n" +
            "F94\n" +
            "W5\n" +
            "S2\n" +
            "L180\n" +
            "W3\n" +
            "F70\n" +
            "S3\n" +
            "R180\n" +
            "W1\n" +
            "N5\n" +
            "R90\n" +
            "S4\n" +
            "F12\n" +
            "S3\n" +
            "F45\n" +
            "E1\n" +
            "N3\n" +
            "R90\n" +
            "S2\n" +
            "L180\n" +
            "E4\n" +
            "S3\n" +
            "W5\n" +
            "F9\n" +
            "S4\n" +
            "R90\n" +
            "F19\n" +
            "W3\n" +
            "N4\n" +
            "W5\n" +
            "R90\n" +
            "F16\n" +
            "W3\n" +
            "S4\n" +
            "W1\n" +
            "S3\n" +
            "R180\n" +
            "S4\n" +
            "E4\n" +
            "N1\n" +
            "W3\n" +
            "F10\n" +
            "N5\n" +
            "E2\n" +
            "F61\n" +
            "E4\n" +
            "S1\n" +
            "W3\n" +
            "N5\n" +
            "W2\n" +
            "L90\n" +
            "W5\n" +
            "N2\n" +
            "W1\n" +
            "F8\n" +
            "W4\n" +
            "S5\n" +
            "L180\n" +
            "F76\n" +
            "N1\n" +
            "R180\n" +
            "S3\n" +
            "R180\n" +
            "S3\n" +
            "E1\n" +
            "R90\n" +
            "W1\n" +
            "F38\n" +
            "R90\n" +
            "F74\n" +
            "N2\n" +
            "F60\n" +
            "L90\n" +
            "E2\n" +
            "S3\n" +
            "F78\n" +
            "W1\n" +
            "F57\n" +
            "R90\n" +
            "F39\n" +
            "N5\n" +
            "F2\n" +
            "E3\n" +
            "R90\n" +
            "F81\n" +
            "E2\n" +
            "F2\n" +
            "S3\n" +
            "R90\n" +
            "F95\n" +
            "S4\n" +
            "F1\n" +
            "E2\n" +
            "N5\n" +
            "L270\n" +
            "F59\n" +
            "W2\n" +
            "R90\n" +
            "S1\n" +
            "F42\n" +
            "E2\n" +
            "N5\n" +
            "E4\n" +
            "L90\n" +
            "W1\n" +
            "F17\n" +
            "E2\n" +
            "F91\n" +
            "R90\n" +
            "E3\n" +
            "F30\n" +
            "S1\n" +
            "R90\n" +
            "W5\n" +
            "F74\n" +
            "W5\n" +
            "N1\n" +
            "N4\n" +
            "R180\n" +
            "S5\n" +
            "R180\n" +
            "F92\n" +
            "N4\n" +
            "N3\n" +
            "E3\n" +
            "R90\n" +
            "F60\n" +
            "S4\n" +
            "L90\n" +
            "E4\n" +
            "R270\n" +
            "F3\n" +
            "E1\n" +
            "L180\n" +
            "E1\n" +
            "S5\n" +
            "F84\n" +
            "E3\n" +
            "L90\n" +
            "N3\n" +
            "F27\n" +
            "W1\n" +
            "F58\n" +
            "N1\n" +
            "F93\n" +
            "N2\n" +
            "F30\n" +
            "L90\n" +
            "N2\n" +
            "L90\n" +
            "N2\n" +
            "F99\n" +
            "W4\n" +
            "S2\n" +
            "F13\n" +
            "L90\n" +
            "N3\n" +
            "W4\n" +
            "F100";
}
