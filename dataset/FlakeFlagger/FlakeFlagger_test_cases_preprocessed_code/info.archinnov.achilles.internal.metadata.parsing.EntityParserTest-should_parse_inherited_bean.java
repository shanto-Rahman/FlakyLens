@Test public void should_parse_inherited_bean() throws Exception {
assertThat(meta).isNotNull();
assertThat(meta.getIdMeta().getPropertyName()).isEqualTo("id");
assertThat(meta.getPropertyMetas().get("name").getPropertyName()).isEqualTo("name");
assertThat(meta.getPropertyMetas().get("address").getPropertyName()).isEqualTo("address");
assertThat(meta.getPropertyMetas().get("nickname").getPropertyName()).isEqualTo("nickname");
}