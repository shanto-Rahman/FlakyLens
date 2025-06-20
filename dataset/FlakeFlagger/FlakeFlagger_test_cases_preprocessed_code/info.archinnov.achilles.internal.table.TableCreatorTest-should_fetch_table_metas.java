@Test public void should_fetch_table_metas() throws Exception {
assertThat(actual.get("table")).isSameAs(tableMeta);
}