@Test public void should_apply_persist_interceptors() throws Exception {
assertThat(row.getString("name")).isEqualTo("prePersist");
assertThat(row.getString("label")).isEqualTo("label");
assertThat(entity.getName()).isEqualTo("prePersist");
assertThat(entity.getLabel()).isEqualTo("postPersist");
}