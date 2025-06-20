@Test public void should_fail_if_lines_count_of_actual_is_not_equal_to_expected_size(){
assertThat(e).hasMessage(shouldHaveLinesCount(actual,2,6).create());
}