@Test public void subsection() throws Exception {
assertThat(subsection.getInputStream(ResourceAccess.PER_READ).read(),equalTo(1));
}