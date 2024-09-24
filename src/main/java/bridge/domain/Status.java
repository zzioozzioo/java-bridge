package bridge.domain;

public enum Status {
    POSSIBLE("O") {
        public Status match(String direction, String target) {
            // TODO: 혹시 이런 건 제네릭으로 풀어야 하나?
            // TODO: 호출할 때 왜 기본을 Status.POSSIBLE.match로 해야 하지?
            if (direction.equals(target)) {
                return POSSIBLE;
            }
            return IMPOSSIBLE;
        }
    },
    IMPOSSIBLE("X") {
        @Override
        public Status match(String Direction, String target) {
            return IMPOSSIBLE;
        }
    };

    final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public abstract Status match(String direction, String target);
}
