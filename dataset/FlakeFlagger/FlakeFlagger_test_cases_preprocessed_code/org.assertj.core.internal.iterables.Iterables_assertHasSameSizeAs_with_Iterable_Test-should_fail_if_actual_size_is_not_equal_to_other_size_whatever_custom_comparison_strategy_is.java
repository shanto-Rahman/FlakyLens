@Test public void should_fail_if_actual_size_is_not_equal_to_other_size_whatever_custom_comparison_strategy_is(){
assertThat(e).hasMessage(shouldHaveSameSizeAs(actual,actual.size(),other.size()).create(null,info.representation()));
}