package step5.view;

import step5.domain.dto.RaceResultDto;

import java.util.ArrayList;
import java.util.List;

public class SimpleResultView implements ResultView {

    private final String token;

    public SimpleResultView(String token) {
        this.token = token;
    }

    @Override
    public List<String> makeResultView(List<RaceResultDto> raceResultDto) {
        List<String> nowResultViewList = new ArrayList<>();
        for (RaceResultDto dto : raceResultDto) {
            nowResultViewList.add(makeEachResultView(dto));
        }
        return nowResultViewList;
    }

    private String makeEachResultView(RaceResultDto raceResultDto) {
        return raceResultDto.getCarName() + " : " + String.valueOf(token).repeat(raceResultDto.getPosition());
    }
}
