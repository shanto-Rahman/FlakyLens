@Test public void createPortFile() throws Exception {
assertThat(FileCopyUtils.copyToString(new FileReader(file)),equalTo("8080"));
}