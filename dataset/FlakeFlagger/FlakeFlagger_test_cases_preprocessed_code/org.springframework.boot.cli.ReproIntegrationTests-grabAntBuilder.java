@Test public void grabAntBuilder() throws Exception {
assertThat(this.cli.getHttpOutput(),containsString("{\"message\":\"Hello World\"}"));
}