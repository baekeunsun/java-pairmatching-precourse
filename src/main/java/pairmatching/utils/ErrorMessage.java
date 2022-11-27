package pairmatching.utils;

public enum ErrorMessage {
    INPUT_NOT_123Q("입력값이 1,2,3,Q 중 하나가 아닙니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
