@Test public void getDirectoryInputStream() throws Exception {
assertThat(inputStream,notNullValue());
assertThat(inputStream.read(),equalTo(-1));
}