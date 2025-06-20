@Test public void should_verify_that_actual_has_time_equals_to_expected(){
assertThat(date).hasSameTimeAs(timestamp);
assertThat(timestamp).hasSameTimeAs(date);
}