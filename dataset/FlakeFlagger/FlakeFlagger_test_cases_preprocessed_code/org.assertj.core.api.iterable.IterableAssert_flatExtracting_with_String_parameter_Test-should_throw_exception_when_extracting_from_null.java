@Test public void should_throw_exception_when_extracting_from_null(){
assertThat(newArrayList(homer,null)).flatExtracting("children");
}