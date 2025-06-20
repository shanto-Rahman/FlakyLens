@Test public void getNestJarEntryUrl() throws Exception {
assertThat(url.toString(),equalTo("jar:" + this.rootJarFile.toURI() + "!/nested.jar!/3.dat"));
assertThat(inputStream,notNullValue());
assertThat(inputStream.read(),equalTo(3));
}