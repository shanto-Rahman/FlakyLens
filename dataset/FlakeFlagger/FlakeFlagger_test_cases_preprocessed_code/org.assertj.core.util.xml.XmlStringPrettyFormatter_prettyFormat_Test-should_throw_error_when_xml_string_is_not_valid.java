@Test public void should_throw_error_when_xml_string_is_not_valid(){
assertThat(e).isInstanceOf(RuntimeException.class).hasMessageStartingWith("Unable to format XML string");
assertThat(e).hasRootCauseInstanceOf(SAXParseException.class);
assertThat(e.getCause()).hasMessageContaining("The element type \"channel\" must be terminated by the matching end-tag \"</channel>\"");
}