@Test public void should_insert() throws Exception {
assertThat(row.getLong("id")).isEqualTo(id);
assertThat(row.getString("value")).isEqualTo("val");
assertThat(row.getString("child_value")).isEqualTo("child_val");
}