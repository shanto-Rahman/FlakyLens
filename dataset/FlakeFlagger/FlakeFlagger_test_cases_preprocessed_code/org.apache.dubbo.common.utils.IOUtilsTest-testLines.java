@Test public void testLines() throws Exception {
IOUtils.writeLines(file,new String[]//RW
assertThat(lines.length,equalTo(1));
assertThat(lines[0],equalTo(TEXT));//RW
}