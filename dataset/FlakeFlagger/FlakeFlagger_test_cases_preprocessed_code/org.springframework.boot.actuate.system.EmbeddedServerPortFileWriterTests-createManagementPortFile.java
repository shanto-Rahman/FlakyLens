@Test public void createManagementPortFile() throws Exception {
assertThat(FileCopyUtils.copyToString(new FileReader(file)),equalTo("8080"));
assertThat(FileCopyUtils.copyToString(new FileReader(new File(file.getParentFile(),managementFile))),equalTo("9090"));
assertThat(collectFileNames(file.getParentFile()),hasItem(managementFile));
}