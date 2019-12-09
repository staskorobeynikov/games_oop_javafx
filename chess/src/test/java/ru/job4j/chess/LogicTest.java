package ru.job4j.chess;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;

public class LogicTest {
    @Test
    public void whenWayHasNotOtherFigure() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        boolean result = logic.move(Cell.C1, Cell.G5);
        Assert.assertThat(result, is(true));
    }
    @Test
    public void whenWayHaveOtherFigure() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.H2));
        logic.add(new BishopBlack(Cell.D6));
        boolean result = logic.move(Cell.H2, Cell.B8);
        Assert.assertThat(result, is(false));
    }
    @Test
    public void whenWayHaveOtherFigureEndWayOtherFigure() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.H2));
        logic.add(new BishopBlack(Cell.D6));
        boolean result = logic.move(Cell.H2, Cell.D6);
        Assert.assertThat(result, is(false));
    }

}
