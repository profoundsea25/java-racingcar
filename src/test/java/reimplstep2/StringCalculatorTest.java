package reimplstep2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.StringAddCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static reimplstep2.StringCalculator.splitAndSum;

class StringCalculatorTest {

    @DisplayName("빈 문자열 또는 null 값 체크")
    @Test
    public void blankOrNullTest() {
        assertThat(splitAndSum(null)).isEqualTo(0);
        assertThat(splitAndSum("")).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}