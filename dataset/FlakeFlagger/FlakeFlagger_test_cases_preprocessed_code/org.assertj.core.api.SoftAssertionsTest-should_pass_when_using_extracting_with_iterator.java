@Test public void should_pass_when_using_extracting_with_iterator(){
softly.assertThat(names).extracting("first").as("using extracting()").contains("John").contains("Jane");
}