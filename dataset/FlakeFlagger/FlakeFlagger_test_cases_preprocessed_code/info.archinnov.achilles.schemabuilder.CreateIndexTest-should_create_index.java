@Test public void should_create_index() throws Exception {
assertThat(statement).isEqualTo("\n\tCREATE INDEX IF NOT EXISTS myIndex ON ks.test(col)");
}