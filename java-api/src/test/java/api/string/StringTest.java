package api.string;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  @DisplayName("문자열 잘라내기")
  void substring_ShouldBeSubString() {
    assertThat("abcdefg".substring(0, 3)).isEqualTo("abc");
  }
}
