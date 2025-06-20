@Test public void testNamedParameterJdbcTemplateExists() throws Exception {
assertNotNull(this.context.getBean(NamedParameterJdbcOperations.class));
}