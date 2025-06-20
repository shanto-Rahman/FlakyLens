@Test public void testGetSubsection() throws Exception {
assertThat(FileCopyUtils.copyToByteArray(data.getInputStream(ResourceAccess.PER_READ)),equalTo(new byte[]{2,3}));
assertThat(data.getSize(),equalTo(2L));
}