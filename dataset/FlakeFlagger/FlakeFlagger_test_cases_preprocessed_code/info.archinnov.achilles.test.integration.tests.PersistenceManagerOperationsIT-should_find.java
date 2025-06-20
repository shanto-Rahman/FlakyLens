@Test public void should_find() throws Exception {
assertThat(found).isNotNull();
assertThat(found.getName()).isEqualTo("Jonathan");
}