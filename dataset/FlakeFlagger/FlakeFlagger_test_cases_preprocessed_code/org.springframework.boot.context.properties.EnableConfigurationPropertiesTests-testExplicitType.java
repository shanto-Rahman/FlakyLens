@Test public void testExplicitType() throws Exception {
assertEquals("foo",this.context.getBean(External.class).getName());
}