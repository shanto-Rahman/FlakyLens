@Test public void createNonNestedUrlFromString() throws Exception {
assertThat(url.toString(),equalTo(spec));
assertThat(inputStream,notNullValue());
assertThat(inputStream.read(),equalTo(2));
assertThat(connection.getURL().toString(),equalTo(spec));
assertThat(connection.getJarFileURL().toURI(),equalTo(this.rootJarFile.toURI()));
assertThat(connection.getEntryName(),equalTo("2.dat"));
}