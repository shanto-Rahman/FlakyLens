@Test public void testGetInputStream() throws Exception {
assertThat(FileCopyUtils.copyToByteArray(data.getInputStream(ResourceAccess.PER_READ)),equalTo(bytes));
assertThat(data.getSize(),equalTo((long)bytes.length));
}