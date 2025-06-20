@Test public void getFilteredJarFile() throws Exception {
if (entryName.toString().equals("1.dat")) {
}
assertThat(entries.nextElement().getName(),equalTo("x.dat"));
assertThat(entries.hasMoreElements(),equalTo(false));
assertThat(inputStream.read(),equalTo(1));
assertThat(inputStream.read(),equalTo(-1));
}