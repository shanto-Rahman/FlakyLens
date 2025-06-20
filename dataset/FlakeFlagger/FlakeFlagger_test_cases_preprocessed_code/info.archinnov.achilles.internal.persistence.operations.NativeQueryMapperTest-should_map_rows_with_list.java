@Test public void should_map_rows_with_list() throws Exception {
assertThat(result).hasSize(1);
assertThat(line).hasSize(1);
assertThat(line.get("friends")).isSameAs(friends);
}