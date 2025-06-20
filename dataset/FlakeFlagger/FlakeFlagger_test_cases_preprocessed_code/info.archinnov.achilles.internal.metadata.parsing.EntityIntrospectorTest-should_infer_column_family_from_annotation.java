@Test public void should_infer_column_family_from_annotation() throws Exception {
assertThat(cfName).isEqualTo("myOwnCF");
}