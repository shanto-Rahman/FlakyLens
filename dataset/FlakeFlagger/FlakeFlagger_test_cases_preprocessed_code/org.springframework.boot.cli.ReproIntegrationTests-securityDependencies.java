@Test public void securityDependencies() throws Exception {
assertThat(this.cli.getOutput(),containsString("Hello World"));
}