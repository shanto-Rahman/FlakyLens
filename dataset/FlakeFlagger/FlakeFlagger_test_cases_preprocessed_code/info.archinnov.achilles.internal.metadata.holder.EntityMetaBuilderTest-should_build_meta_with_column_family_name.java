@Test public void should_build_meta_with_column_family_name() throws Exception {
assertThat(meta.getClassName()).isEqualTo("Bean");
assertThat(meta.getTableName()).isEqualTo("toto");
}