@Test public void should_build_meta() throws Exception {
assertThat(meta.<CompleteBean>getEntityClass()).isEqualTo(CompleteBean.class);
assertThat(meta.getClassName()).isEqualTo("Bean");
assertThat(meta.getTableName()).isEqualTo("cfName");
assertThat(meta.getIdMeta()).isSameAs(idMeta);
assertThat(meta.<Long>getIdClass()).isEqualTo(Long.class);
assertThat(meta.getPropertyMetas()).containsKey("name");
assertThat(meta.getPropertyMetas()).containsValue(simpleMeta);
assertThat(meta.getGetterMetas()).hasSize(1);
assertThat(meta.getGetterMetas().containsKey(getter));
assertThat(meta.getGetterMetas().get(getter)).isSameAs(simpleMeta);
assertThat(meta.getSetterMetas()).hasSize(1);
assertThat(meta.getSetterMetas().containsKey(setter));
assertThat(meta.getSetterMetas().get(setter)).isSameAs(simpleMeta);
}