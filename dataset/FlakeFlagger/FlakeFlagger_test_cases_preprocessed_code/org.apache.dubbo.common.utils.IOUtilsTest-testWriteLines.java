@Test public void testWriteLines() throws Exception {
IOUtils.writeLines(os,new String[]//RW
assertThat(new String(bos.toByteArray()),equalTo(TEXT + System.lineSeparator()));//RW
}