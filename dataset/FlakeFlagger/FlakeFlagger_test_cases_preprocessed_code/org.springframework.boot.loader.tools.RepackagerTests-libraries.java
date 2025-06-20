@Test public void libraries() throws Exception {
assertThat(hasEntry(file,"lib/" + libJarFile.getName()),equalTo(true));
assertThat(hasEntry(file,"lib/" + libJarFileToUnpack.getName()),equalTo(true));
assertThat(hasEntry(file,"lib/" + libNonJarFile.getName()),equalTo(false));
assertThat(entry.getComment(),startsWith("UNPACK:"));
assertThat(entry.getComment().length(),equalTo(47));
}