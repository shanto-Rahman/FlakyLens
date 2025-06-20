@Test public void should_insert_only_fields_that_are_not_null() throws Exception {
assertThat(found.getName()).isEqualTo("Helen");
assertThat(found.getAge()).isEqualTo(33L);
}