@Test public void testEncodingWorks() throws Exception {
assertEquals("Some text with some swedish öäå!",this.context.getMessage("foo",null,"Foo message",Locale.UK));
}