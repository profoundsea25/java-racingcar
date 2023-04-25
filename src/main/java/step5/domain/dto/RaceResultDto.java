package step5.domain.dto;

public class RaceResultDto {
    private final String carName;
    private final int position;

    public RaceResultDto(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
