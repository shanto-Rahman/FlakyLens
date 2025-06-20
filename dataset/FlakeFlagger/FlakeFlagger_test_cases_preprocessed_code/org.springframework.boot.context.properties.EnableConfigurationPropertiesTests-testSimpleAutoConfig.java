@Test public void testSimpleAutoConfig() throws Exception {
assertEquals("foo",this.context.getBean(External.class).getName());
}