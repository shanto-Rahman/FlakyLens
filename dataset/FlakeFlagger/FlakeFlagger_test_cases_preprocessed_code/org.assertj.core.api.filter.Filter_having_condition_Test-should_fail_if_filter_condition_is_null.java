@Test public void should_fail_if_filter_condition_is_null(){
fail("NullPointerException expected");
assertThat(e).hasMessage("The filter condition should not be null");
}