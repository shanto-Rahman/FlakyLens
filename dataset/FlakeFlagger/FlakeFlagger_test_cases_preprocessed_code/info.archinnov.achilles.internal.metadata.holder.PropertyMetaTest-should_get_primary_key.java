@Test public void should_get_primary_key() throws Exception {
assertThat(pm.getPrimaryKey(entity)).isEqualTo(id);
}