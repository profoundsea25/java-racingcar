package step5.view;

import step5.domain.dto.RaceResultDto;

import java.util.List;

@FunctionalInterface
public interface ResultView {
    List<String> makeResultView(List<RaceResultDto> raceResultDto);
}
