package ru.job4j.chess;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

public class LogicTest {

    @Ignore
    @Test
    public void move()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.D2));
        Assert.assertThrows(ImpossibleMoveException.class, () -> {
            logic.move(Cell.C1, Cell.H5);
        });
        Assert.assertThrows(OccupiedCellException.class, () -> {
            logic.move(Cell.C1, Cell.D2);
        });
        Assert.assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.H1, Cell.D2);
        });
    }
}