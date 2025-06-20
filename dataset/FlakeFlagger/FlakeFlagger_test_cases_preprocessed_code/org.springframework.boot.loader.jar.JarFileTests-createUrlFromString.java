@Test public void createUrlFromString() throws Exception {
assertThat(url.toString(),equalTo(spec));
assertThat(inputStream,notNullValue());
assertThat(inputStream.read(),equalTo(3));
assertThat(connection.getURL().toString(),equalTo(spec));
assertThat(connection.getJarFileURL().toString(),equalTo("jar:" + this.rootJarFile.toURI() + "!/nested.jar"));
assertThat(connection.getEntryName(),equalTo("3.dat"));
}