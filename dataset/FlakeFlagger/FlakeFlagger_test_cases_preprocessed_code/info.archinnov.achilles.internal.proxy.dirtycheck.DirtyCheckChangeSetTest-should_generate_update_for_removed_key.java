@Test public void should_generate_update_for_removed_key() throws Exception {
assertThat(vals[0]).isEqualTo(1);
assertThat(vals[1]).isNull();
assertThat(conditions.getQueryString()).isEqualTo("UPDATE table SET property[1]=null;");
}