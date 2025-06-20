@Test public void should_add_column() throws Exception {
assertThat(built).isEqualTo("\n\tALTER TABLE test ADD location ascii");
}