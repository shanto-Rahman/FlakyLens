@Test public void testDefaultMessageSource() throws Exception {
assertEquals("Foo message",this.context.getMessage("foo",null,"Foo message",Locale.UK));
}