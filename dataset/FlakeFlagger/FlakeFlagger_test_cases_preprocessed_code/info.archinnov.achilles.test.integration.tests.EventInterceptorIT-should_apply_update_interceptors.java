@Test public void should_apply_update_interceptors() throws Exception {
assertThat(row.getString("name")).isEqualTo("preUpdate");
assertThat(row.getString("label")).isEqualTo("label");
assertThat(entity.getName()).isEqualTo("preUpdate");
assertThat(entity.getLabel()).isEqualTo("postUpdate");
}