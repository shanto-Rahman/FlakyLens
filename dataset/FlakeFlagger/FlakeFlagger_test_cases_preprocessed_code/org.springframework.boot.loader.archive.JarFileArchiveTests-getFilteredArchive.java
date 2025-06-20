@Test public void getFilteredArchive() throws Exception {
if (entryName.toString().equals("1.dat")) {
}
assertThat(entries.size(),equalTo(1));
}