@Test public void should_find_getter_from_boolean_as_isOld() throws Exception {
assertThat(accessors[0].getName()).isEqualTo("isOld");
}