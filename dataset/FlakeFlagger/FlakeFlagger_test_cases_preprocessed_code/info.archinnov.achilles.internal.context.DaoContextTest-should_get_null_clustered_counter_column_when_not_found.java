@Test public void should_get_null_clustered_counter_column_when_not_found() throws Exception {
assertThat(actual).isNull();
}