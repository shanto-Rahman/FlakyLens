@Test public void writePid() throws Exception {
String actual=FileCopyUtils.copyToString(new FileReader(file));
assertThat(actual,equalTo("123"));
}