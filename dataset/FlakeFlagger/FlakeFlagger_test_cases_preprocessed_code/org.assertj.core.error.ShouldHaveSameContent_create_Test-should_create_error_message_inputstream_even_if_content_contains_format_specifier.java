@Test public void should_create_error_message_inputstream_even_if_content_contains_format_specifier(){
assertThat(factory.create(new TextDescription("Test"),new StandardRepresentation())).isEqualTo(b.toString());
}