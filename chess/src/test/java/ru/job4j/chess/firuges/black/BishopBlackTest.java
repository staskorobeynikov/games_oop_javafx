package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import org.junit.Assert;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {
    @Test
    public void whenCreateBishop() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(Cell.C1, is(bishopBlack.position()));
    }
    @Test
    public void whenCopyBishop() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Figure bishopBlack1 = bishopBlack.copy(Cell.E3);
        assertThat(bishopBlack1.position(), is(Cell.E3));
    }
    @Test
    public void whenBishopWayRight() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] bishopcells = bishopBlack.way(Cell.C1, Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(bishopcells, is(expected));
    }
    @Test
    public void whenBishopWayLeft() {
        BishopBlack bishopBlack = new BishopBlack(Cell.E6);
        Cell[] bishopcells = bishopBlack.way(Cell.E6, Cell.A2);
        Cell[] expected = {Cell.D5, Cell.C4, Cell.B3, Cell.A2};
        assertThat(bishopcells, is(expected));
    }
    @Test(expected = IllegalStateException.class)
    public void whenBishopWayNotCorrect() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] bishopcells = bishopBlack.way(bishopBlack.position(), Cell.C5);
    }
}
