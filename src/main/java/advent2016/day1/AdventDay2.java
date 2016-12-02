package advent2016.day1;

/**
 * Created by Deesha Singh on 2016/12/02.
 */
public class AdventDay2 {

    public static String[] getStringArrayOfDirections(String input) {
        return input.split("\n");
    }

    public static String solution(String input, String keyboard) {
        String[] buttonDirections = getStringArrayOfDirections(input);
        KeyboardA currentButtonA = KeyboardA.FIVE;
        KeyboardB currentButtonB = KeyboardB.FIVE;
        String code = "";
        for (String dir : buttonDirections) {
            String[] indivDirs = dir.split("");
            for (String d : indivDirs) {
                if (d.equalsIgnoreCase("U")) {
                    currentButtonA = currentButtonA.up;
                    currentButtonB = currentButtonB.up;
                } else if (d.equalsIgnoreCase("D")) {
                    currentButtonA = currentButtonA.down;
                    currentButtonB = currentButtonB.down;
                } else if (d.equalsIgnoreCase("R")) {
                    currentButtonA = currentButtonA.right;
                    currentButtonB = currentButtonB.right;
                } else if (d.equalsIgnoreCase("L")) {
                    currentButtonA = currentButtonA.left;
                    currentButtonB = currentButtonB.left;
                }
            }
            if (keyboard.equalsIgnoreCase("A")) {
                code = code + String.valueOf(currentButtonA.buttonNumber);
            } else {
                code = code + String.valueOf(currentButtonB.buttonNumber);
            }
        }
        return code;
    }

    enum KeyboardA {
        ONE('1'), TWO('2'), THREE('3'), FOUR('4'), FIVE('5'), SIX('6'), SEVEN('7'), EIGHT('8'), NINE('9');

        Character buttonNumber;

        KeyboardA left, right, up, down;

        static {
            ONE.left = ONE;
            ONE.right = TWO;
            ONE.up = ONE;
            ONE.down = FOUR;

            TWO.left = ONE;
            TWO.right = THREE;
            TWO.up = TWO;
            TWO.down = FIVE;

            THREE.left = TWO;
            THREE.right = THREE;
            THREE.up = THREE;
            THREE.down = SIX;

            FOUR.left = FOUR;
            FOUR.right = FIVE;
            FOUR.up = ONE;
            FOUR.down = SEVEN;

            FIVE.left = FOUR;
            FIVE.right = SIX;
            FIVE.up = TWO;
            FIVE.down = EIGHT;

            SIX.left = FIVE;
            SIX.right = SIX;
            SIX.up = THREE;
            SIX.down = NINE;

            SEVEN.left = SEVEN;
            SEVEN.right = EIGHT;
            SEVEN.up = FOUR;
            SEVEN.down = SEVEN;

            EIGHT.left = SEVEN;
            EIGHT.right = NINE;
            EIGHT.up = FIVE;
            EIGHT.down = EIGHT;

            NINE.left = EIGHT;
            NINE.right = NINE;
            NINE.up = SIX;
            NINE.down = NINE;
        }

        KeyboardA(Character buttonNumber) {
            this.buttonNumber = buttonNumber;
        }
    }

    enum KeyboardB {
        ONE('1'), TWO('2'), THREE('3'), FOUR('4'), FIVE('5'), SIX('6'), SEVEN('7'), EIGHT('8'), NINE('9'), A('A'), B('B'), C('C'), D('D');

        Character buttonNumber;

        KeyboardB left, right, up, down;

        static {
            ONE.left = ONE;
            ONE.right = ONE;
            ONE.up = ONE;
            ONE.down = THREE;

            TWO.left = TWO;
            TWO.right = THREE;
            TWO.up = TWO;
            TWO.down = SIX;

            THREE.left = TWO;
            THREE.right = FOUR;
            THREE.up = ONE;
            THREE.down = SEVEN;

            FOUR.left = THREE;
            FOUR.right = FOUR;
            FOUR.up = FOUR;
            FOUR.down = EIGHT;

            FIVE.left = FIVE;
            FIVE.right = SIX;
            FIVE.up = FIVE;
            FIVE.down = FIVE;

            SIX.left = FIVE;
            SIX.right = SEVEN;
            SIX.up = TWO;
            SIX.down = A;

            SEVEN.left = SIX;
            SEVEN.right = EIGHT;
            SEVEN.up = THREE;
            SEVEN.down = B;

            EIGHT.left = SEVEN;
            EIGHT.right = NINE;
            EIGHT.up = FOUR;
            EIGHT.down = C;

            NINE.left = EIGHT;
            NINE.right = NINE;
            NINE.up = NINE;
            NINE.down = NINE;

            A.left = A;
            A.right = B;
            A.up = SIX;
            A.down = A;

            B.left = A;
            B.right = C;
            B.up = SEVEN;
            B.down = D;

            C.left = B;
            C.right = C;
            C.up = EIGHT;
            C.down = C;

            D.right = D;
            D.up = B;
            D.down = D;
            D.left = D;
        }

        KeyboardB(Character buttonNumber) {
            this.buttonNumber = buttonNumber;
        }
    }
}
