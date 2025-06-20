@Test public void should_throw_error_when_xml_string_is_null(){
assertThat(e).isInstanceOf(IllegalArgumentException.class).hasMessageStartingWith("Expecting XML String not to be null");
}