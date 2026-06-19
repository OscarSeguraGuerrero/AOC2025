package software.ulpgc.aoc2025.shared;

import java.io.IOException;
import java.util.List;

public interface PuzzleReader {
    List<String> readLines() throws IOException;
}
