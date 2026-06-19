package software.ulpgc.aoc2025.day01;

import software.ulpgc.aoc2025.day01.model.Rotation;

import java.util.List;

public class DialSimulator {
    private static final int DIAL_SIZE = 100;
    private static final int INITIAL_POSITION = 50;

    public static long countZeroCrossings(List<Rotation> rotations) {
        int[] position = {INITIAL_POSITION};
        return rotations.stream()
                .mapToInt(r -> position[0] = applyRotation(position[0], r))
                .filter(p -> p == 0)
                .count();
    }

    private static int applyRotation(int position, Rotation rotation) {
        int delta = rotation.direction() == 'R' ? rotation.distance() : -rotation.distance();
        return ((position + delta) % DIAL_SIZE + DIAL_SIZE) % DIAL_SIZE;
    }
}
