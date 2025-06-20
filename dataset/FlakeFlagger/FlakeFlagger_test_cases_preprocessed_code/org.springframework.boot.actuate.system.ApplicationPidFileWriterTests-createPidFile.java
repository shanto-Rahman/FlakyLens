@Test public void createPidFile() throws Exception {
assertThat(FileCopyUtils.copyToString(new FileReader(file)),not(isEmptyString()));
}