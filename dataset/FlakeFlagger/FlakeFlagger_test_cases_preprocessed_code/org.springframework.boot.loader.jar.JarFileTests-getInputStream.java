@Test public void getInputStream() throws Exception {
assertThat(inputStream.available(),equalTo(1));
assertThat(inputStream.read(),equalTo(1));
assertThat(inputStream.available(),equalTo(0));
assertThat(inputStream.read(),equalTo(-1));
}