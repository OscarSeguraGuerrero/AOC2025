package software.ulpgc.aoc2025.day01.model;

public record Rotation(char direction, int distance) {

    public static Rotation parse(String line) {
        char direction = line.charAt(0);
        int distance = Integer.parseInt(line.substring(1));
        return new Rotation(direction, distance);
    }
}
