@Test public void should_pass_when_using_flat_extracting(){
softly.assertThat(characters).flatExtracting(children()).as("using flatExtracting on Iterable").hasSize(4);
softly.assertThat(charactersAsArray).flatExtracting(children()).as("using flatExtracting on array").hasSize(4);
}