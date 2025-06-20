@Test public void getJarEntry() throws Exception {
assertThat(entry,notNullValue(ZipEntry.class));
assertThat(entry.getName(),equalTo("1.dat"));
}