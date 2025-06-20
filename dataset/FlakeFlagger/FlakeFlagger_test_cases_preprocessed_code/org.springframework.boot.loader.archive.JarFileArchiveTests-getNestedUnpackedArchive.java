@Test public void getNestedUnpackedArchive() throws Exception {
assertThat(nested.getUrl().toString(),startsWith("file:"));
assertThat(nested.getUrl().toString(),endsWith(".jar"));
}