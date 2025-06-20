@Test public void should_parse_entity_with_embedded_id() throws Exception {
assertThat(meta).isNotNull();
assertThat(meta.<EmbeddedKey>getIdClass()).isEqualTo(EmbeddedKey.class);
assertThat(idMeta.isEmbeddedId()).isTrue();
assertThat(idMeta.getComponentClasses()).containsExactly(Long.class,String.class);
}