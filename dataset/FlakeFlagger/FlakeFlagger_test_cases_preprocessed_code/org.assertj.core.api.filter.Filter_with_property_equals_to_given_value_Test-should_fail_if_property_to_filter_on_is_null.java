@Test public void should_fail_if_property_to_filter_on_is_null(){
fail("NullPointerException expected");
assertThat(e).hasMessage("The property name to filter on should not be null");
}