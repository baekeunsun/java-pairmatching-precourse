package pairmatching.utils;

public enum ErrorMessage {
    INPUT_NOT_123Q("입력값이 1,2,3,Q 중 하나가 아닙니다."),
    NOT_EXIST_CREW("존재하지 않는 멤버입니다."),
    NOT_EXIST_LEVEL("존재하지 않는 레벨입니다."),
    NOT_EXIST_MISSION("존재하지 않는 미션입니다."),
    NOT_EXIST_PAIR("매칭 이력이 없습니다."),
    NOT_YES_OR_NO("입력값이 네,아니오 중 하나가 아닙니다."),
    EXCESS_COUNT("매칭이 3회 초과되었습니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
