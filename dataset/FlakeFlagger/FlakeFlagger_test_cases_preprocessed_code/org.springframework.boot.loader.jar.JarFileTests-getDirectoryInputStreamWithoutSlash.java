@Test public void getDirectoryInputStreamWithoutSlash() throws Exception {
assertThat(inputStream,notNullValue());
assertThat(inputStream.read(),equalTo(-1));
}