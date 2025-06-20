@Test public void should_format_Object_array_that_has_primitive_array_as_element(){
assertEquals("[\"Hello\", [true, false]]",formatter.format(new StandardRepresentation(),array));//RW
}