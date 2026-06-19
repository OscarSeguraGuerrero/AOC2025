package software.ulpgc.aoc2025.day01;

import software.ulpgc.aoc2025.day01.model.Rotation;
import software.ulpgc.aoc2025.shared.FilePuzzleReader;
import software.ulpgc.aoc2025.shared.PuzzleReader;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Part1 {
    public static void main(String[] args) throws IOException {
        PuzzleReader reader = FilePuzzleReader.of("src/main/resources/day01/input.txt");

        List<Rotation> rotations = reader.readLines().stream()
                .map(Rotation::parse)
                .collect(Collectors.toList());

        long password = DialSimulator.countZeroCrossings(rotations);
        System.out.println("Day 01 - Part 1: " + password);
    }
}
