@Test public void should_generate_update_for_removed_key_with_bind_marker() throws Exception {
assertThat(vals[0]).isEqualTo(1);
assertThat(vals[1]).isNull();
assertThat(conditions.getQueryString()).isEqualTo("UPDATE table SET property[:key]=:nullValue;");
}