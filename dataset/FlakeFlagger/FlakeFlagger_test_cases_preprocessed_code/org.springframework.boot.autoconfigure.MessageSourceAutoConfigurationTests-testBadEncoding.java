@Test public void testBadEncoding() throws Exception {
assertEquals("blah",this.context.getMessage("foo",null,"blah",Locale.UK));
}