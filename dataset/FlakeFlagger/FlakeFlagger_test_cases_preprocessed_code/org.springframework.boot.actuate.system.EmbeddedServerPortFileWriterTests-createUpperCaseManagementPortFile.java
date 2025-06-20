@Test public void createUpperCaseManagementPortFile() throws Exception {
file=new File(file.getParentFile(),file.getName().toUpperCase());
assertThat(FileCopyUtils.copyToString(new FileReader(new File(file.getParentFile(),managementFile))),equalTo("9090"));
assertThat(collectFileNames(file.getParentFile()),hasItem(managementFile));
}