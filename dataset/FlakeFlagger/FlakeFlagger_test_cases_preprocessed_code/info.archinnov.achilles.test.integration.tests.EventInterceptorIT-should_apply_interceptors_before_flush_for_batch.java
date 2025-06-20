@Test public void should_apply_interceptors_before_flush_for_batch() throws Exception {
assertThat(entity.getName()).isEqualTo("DuyHai");
assertThat(entity.getLabel()).isEqualTo("label");
assertThat(entity.getName()).isEqualTo("prePersist");
assertThat(entity.getLabel()).isEqualTo("postPersist");
}