@Test public void should_insert_all_fields() throws Exception {
assertThat(found.getName()).isEqualTo("Helen");
assertThat(found.getAge()).isNull();
}