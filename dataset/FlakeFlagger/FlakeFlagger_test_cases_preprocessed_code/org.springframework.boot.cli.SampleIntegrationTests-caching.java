@Test public void caching() throws Exception {
assertThat(this.cli.getOutput(),containsString("Hello World"));
}