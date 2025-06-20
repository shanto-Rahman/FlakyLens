public void testIncludeUsingAnnotation() throws Exception {
assertEquals("{\"value\":3}",json);
assertEquals("{}",json);
assertEquals("{\"name\":\"Foo\",\"wrapped\":{}}",json);
assertEquals("{\"name\":\"Foo\"}",json);
}