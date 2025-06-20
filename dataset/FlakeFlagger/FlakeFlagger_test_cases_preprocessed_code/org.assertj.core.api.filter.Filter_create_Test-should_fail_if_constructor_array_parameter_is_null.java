@Test public void should_fail_if_constructor_array_parameter_is_null(){
fail("NullPointerException expected");
assertThat(e).hasMessage("The array to filter should not be null");
}