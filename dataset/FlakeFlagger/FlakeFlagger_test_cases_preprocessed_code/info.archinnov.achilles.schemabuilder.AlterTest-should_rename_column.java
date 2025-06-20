@Test public void should_rename_column() throws Exception {
assertThat(built).isEqualTo("\n\tALTER TABLE test RENAME name TO description");
}