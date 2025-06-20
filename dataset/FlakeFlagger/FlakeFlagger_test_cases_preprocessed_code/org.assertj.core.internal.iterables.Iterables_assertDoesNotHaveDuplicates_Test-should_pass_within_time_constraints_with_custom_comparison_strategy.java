@Test public void should_pass_within_time_constraints_with_custom_comparison_strategy(){
assertThat((System.currentTimeMillis() - time)).isLessThan(10000);
}