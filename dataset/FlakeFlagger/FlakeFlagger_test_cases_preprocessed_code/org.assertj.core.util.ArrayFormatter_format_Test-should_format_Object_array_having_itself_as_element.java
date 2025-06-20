@Test public void should_format_Object_array_having_itself_as_element(){
assertEquals("[[\"Hello\", [...]]]",formatter.format(new StandardRepresentation(),array2));//RW
}