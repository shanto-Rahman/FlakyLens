@Test public void getFilteredArchive() throws Exception {
if (entryName.toString().equals("1.dat")) {
}
assertThat(entries.size(),equalTo(1));
assertThat(classLoader.getResourceAsStream("1.dat").read(),equalTo(1));
assertThat(classLoader.getResourceAsStream("2.dat"),nullValue());
}