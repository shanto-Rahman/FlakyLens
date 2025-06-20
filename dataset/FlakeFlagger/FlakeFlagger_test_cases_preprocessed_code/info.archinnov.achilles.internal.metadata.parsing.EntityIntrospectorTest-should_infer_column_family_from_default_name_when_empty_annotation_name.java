@Test public void should_infer_column_family_from_default_name_when_empty_annotation_name() throws Exception {
assertThat(cfName).isEqualTo("canonicalName");
}