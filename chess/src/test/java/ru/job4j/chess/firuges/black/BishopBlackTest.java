package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Assert;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlackTest extends TestCase {

    public void testPositionWhenC1ThenC1() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        Assert.assertEquals(bb.position(), Cell.C1);
    }

    public void testWayWhenException() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        Assert.assertThrows(ImpossibleMoveException.class, () -> {
            bb.way(Cell.G4);
        });
    }

    public void testWayWhenG5ThenG5() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        Assert.assertArrayEquals(bb.way(Cell.G5), new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5});
    }

    public void testCopyWhenE5ThenE5() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        Figure f = bb.copy(Cell.E5);
        Assert.assertEquals(f.position(), Cell.E5);
    }
}