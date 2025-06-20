@Test public void should_fail_if_constructor_iterable_parameter_is_null(){
fail("NullPointerException expected");
assertThat(e).hasMessage("The iterable to filter should not be null");
}