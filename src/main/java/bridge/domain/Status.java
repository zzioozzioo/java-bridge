package bridge.domain;

public enum Status {
    POSSIBLE("O"),
    IMPOSSIBLE("X"),
    EMPTY(" ");

    final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
