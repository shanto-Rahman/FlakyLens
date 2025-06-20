@Test public void should_get_all_metas() throws Exception {
assertThat(entityMeta.getAllMetas()).containsExactly(pm1,pm2);
}