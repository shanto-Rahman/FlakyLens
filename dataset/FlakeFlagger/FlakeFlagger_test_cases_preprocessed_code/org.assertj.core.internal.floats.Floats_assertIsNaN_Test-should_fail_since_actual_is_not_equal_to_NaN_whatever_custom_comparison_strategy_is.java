@Test public void should_fail_since_actual_is_not_equal_to_NaN_whatever_custom_comparison_strategy_is(){
assertEquals(e.getMessage(),"expected:<[NaN]f> but was:<[6.0]f>");
}