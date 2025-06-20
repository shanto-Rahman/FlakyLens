@Test public void renamesDuplicates() throws Exception {
given(artifact1.getFile()).willReturn(new File("a"));//RO
given(artifact2.getFile()).willReturn(new File("a"));//RO
assertThat(this.libraryCaptor.getAllValues().get(0).getName(),equalTo("g1-a"));
assertThat(this.libraryCaptor.getAllValues().get(1).getName(),equalTo("g2-a"));
}