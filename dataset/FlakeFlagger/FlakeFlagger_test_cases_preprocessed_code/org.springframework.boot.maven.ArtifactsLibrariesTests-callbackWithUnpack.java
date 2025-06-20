@Test public void callbackWithUnpack() throws Exception {
assertThat(this.libraryCaptor.getValue().isUnpackRequired(),equalTo(true));
}