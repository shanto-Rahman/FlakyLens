@Test public void should_extract_tuples_from_fields_or_properties(){
assertThat(extractedValue).isEqualTo(tuple(1L,800));
}