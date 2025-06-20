@Test public void subsectionZeroLength() throws Exception {
assertThat(subsection.getInputStream(ResourceAccess.PER_READ).read(),equalTo(-1));
}