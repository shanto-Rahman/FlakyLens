@Test public void should_find() throws Exception {
assertThat(found).isNotNull();
assertThat(found).isInstanceOf(Factory.class);
assertThat(found.getId().getId()).isEqualTo(id);
assertThat(found.getId().getType()).isEqualTo("type");
assertThat(found.getValue()).isEqualTo("value");
}