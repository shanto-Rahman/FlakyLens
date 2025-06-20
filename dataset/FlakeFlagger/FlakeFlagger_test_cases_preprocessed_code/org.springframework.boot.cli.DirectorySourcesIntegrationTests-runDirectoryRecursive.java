@Test public void runDirectoryRecursive() throws Exception {
assertThat(this.cli.getOutput(),containsString("Hello World"));
}