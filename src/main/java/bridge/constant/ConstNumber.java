package bridge.constant;

public enum ConstNumber {
    MIN_SIZE(3),
    MAX_SIZE(20);

    final int size;
    ConstNumber(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
