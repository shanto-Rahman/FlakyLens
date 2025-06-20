@Test public void testMultipleMessageSourceCreated() throws Exception {
assertEquals("bar",this.context.getMessage("foo",null,"Foo message",Locale.UK));
assertEquals("bar-bar",this.context.getMessage("foo-foo",null,"Foo-Foo message",Locale.UK));
}