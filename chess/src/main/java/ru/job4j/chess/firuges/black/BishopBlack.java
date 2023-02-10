package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int x = dest.getX() - position.getX();
        int y =  dest.getY() - position.getY();;
        if (Math.abs(x) != Math.abs(y)) {
            throw new ImpossibleMoveException(String.format("Could not way by diagonal from %s to %s", position, dest));
        }
        var res = new Cell[Math.abs(x)];
        for (int i = 0; i < Math.abs(x); i++) {
            res[i] = Cell.findBy(position.getX() + Integer.signum(x) * (i + 1),  position.getY() + Integer.signum(y) * (i + 1));
        }
        return res;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        if (Math.abs(source.getX() - dest.getX()) == Math.abs((source.getY() - dest.getY()))) {
            return true;
        }
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
