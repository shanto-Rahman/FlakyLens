@Test public void shellDependencies() throws Exception {
assertThat(this.cli.getHttpOutput(),containsString("{\"message\":\"Hello World\"}"));
}