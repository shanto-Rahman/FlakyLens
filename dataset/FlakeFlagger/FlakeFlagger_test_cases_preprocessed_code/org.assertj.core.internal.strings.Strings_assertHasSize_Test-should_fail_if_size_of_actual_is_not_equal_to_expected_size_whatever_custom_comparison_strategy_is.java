@Test public void should_fail_if_size_of_actual_is_not_equal_to_expected_size_whatever_custom_comparison_strategy_is(){
assertThat(e).hasMessage(shouldHaveSize(actual,actual.length(),6).create());
}