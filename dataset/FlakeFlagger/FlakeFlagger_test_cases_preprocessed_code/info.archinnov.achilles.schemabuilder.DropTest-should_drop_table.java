@Test public void should_drop_table() throws Exception {
assertThat(built).isEqualTo("DROP TABLE test");
}