@Test public void should_prepare_statement() throws Exception {
assertThat(daoContext.prepare(statement)).isSameAs(ps);
}