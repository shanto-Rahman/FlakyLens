@Test public void overridePortFile() throws Exception {
assertThat(FileCopyUtils.copyToString(new FileReader(System.getProperty("PORTFILE"))),equalTo("8080"));
}