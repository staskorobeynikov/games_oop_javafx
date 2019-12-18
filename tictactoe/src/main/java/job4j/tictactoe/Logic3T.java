package job4j.tictactoe;

import java.util.Arrays;
import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY,
                          int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerX() {
        return isWin(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return isWin(Figure3T::hasMarkO);
    }
    public boolean isWin(Predicate<Figure3T> predicate) {
        boolean isCombinationHorizontal = false;
        boolean isCombinationVertical = false;
        for (int i = 0; i < table.length; i++) {
            if (fillBy(predicate, i, 0, 0, 1)) {
                isCombinationHorizontal = true;
            }
            if (fillBy(predicate, 0, i, 1, 0)) {
                isCombinationVertical = true;
            }
        }
        return isCombinationHorizontal || isCombinationVertical
                || fillBy(predicate, 0, 0, 1, 1) || fillBy(predicate, table.length - 1, 0, -1, 1);
    }

    public boolean hasGap() {
        return !Arrays.stream(table)
                .flatMap(Arrays::stream)
                .allMatch(w -> w.hasMarkX() || w.hasMarkO());
    }
}
