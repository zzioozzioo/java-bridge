package bridge.domain;

import bridge.exception.InvalidBridgeSizeException;

public enum Range {
    MIN_SIZE(3),
    MAX_SIZE(20);

    final int size;
    Range(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public static void validateSize(int bridgeSize) {
        if (bridgeSize < Range.MIN_SIZE.getSize() || bridgeSize > Range.MAX_SIZE.getSize()) {
            throw new InvalidBridgeSizeException();
        }
    }
}
