package software.ulpgc.aoc2025.shared;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FilePuzzleReader implements PuzzleReader {
    private final Path path;

    private FilePuzzleReader(Path path) {
        this.path = path;
    }

    public static FilePuzzleReader of(String path) {
        return new FilePuzzleReader(Path.of(path));
    }

    @Override
    public List<String> readLines() throws IOException {
        return Files.readAllLines(path);
    }
}
