@Test public void callbackForJars() throws Exception {
assertThat(library.getFile(),equalTo(this.file));
assertThat(library.getScope(),equalTo(LibraryScope.COMPILE));
assertThat(library.isUnpackRequired(),equalTo(false));
}