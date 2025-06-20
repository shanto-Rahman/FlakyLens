@Test public void should_drop_column() throws Exception {
assertThat(built).isEqualTo("\n\tALTER TABLE test DROP name");
}