@Test public void should_set_primaryKey_to_true_when_embedded_id() throws Exception {
assertThat(context.isEmbeddedId()).isTrue();
assertThat(context.isPrimaryKey()).isTrue();
}