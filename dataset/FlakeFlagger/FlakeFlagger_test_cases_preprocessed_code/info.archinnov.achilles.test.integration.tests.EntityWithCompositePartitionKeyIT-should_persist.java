@Test public void should_persist() throws Exception {
assertThat(row).isNotNull();
assertThat(row.getLong("id")).isEqualTo(id);
assertThat(row.getString("type")).isEqualTo("type");
assertThat(row.getString("value")).isEqualTo("value");
}