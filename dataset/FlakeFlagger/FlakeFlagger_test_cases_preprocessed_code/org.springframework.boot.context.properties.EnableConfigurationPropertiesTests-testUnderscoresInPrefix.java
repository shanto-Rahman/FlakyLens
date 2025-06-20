@Test public void testUnderscoresInPrefix() throws Exception {
assertEquals("baz",this.context.getBean(SystemEnvVar.class).getVal());
}