@Test public void should_return_all_property_metas_for_columnsMetaToLoad() throws Exception {
assertThat(meta.getColumnsMetaToLoad()).containsExactly(propertyMeta);
}