@Test public void should_fail_if_second_double_is_null_but_not_the_first_whatever_custom_comparison_strategy_is(){
assertThat(e).hasMessage("The given number should not be null");
}