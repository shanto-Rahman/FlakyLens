@Test public void runDirectory() throws Exception {
assertThat(this.cli.getOutput(),containsString("Hello World"));
}