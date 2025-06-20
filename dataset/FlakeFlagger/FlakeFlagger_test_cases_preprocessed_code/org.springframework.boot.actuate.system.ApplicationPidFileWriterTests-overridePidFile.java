@Test public void overridePidFile() throws Exception {
assertThat(FileCopyUtils.copyToString(new FileReader(System.getProperty("PIDFILE"))),not(isEmptyString()));
}