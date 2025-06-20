@Test public void should_extract_tuples_with_consistent_iteration_order(){
assertThat(extractedValues).isEqualTo(tuple(1L,"Yoda",800));
}