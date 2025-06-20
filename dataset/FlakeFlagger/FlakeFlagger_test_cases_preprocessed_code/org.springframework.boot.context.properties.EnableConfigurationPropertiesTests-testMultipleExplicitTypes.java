@Test public void testMultipleExplicitTypes() throws Exception {
assertEquals("foo",this.context.getBean(External.class).getName());
assertEquals("bar",this.context.getBean(Another.class).getName());
}