@Test public void should_map_rows() throws Exception {
assertThat(result).hasSize(1);
assertThat(line).hasSize(2);
assertThat(line.get("id")).isEqualTo(id);
assertThat(line.get("name")).isEqualTo(name);
}