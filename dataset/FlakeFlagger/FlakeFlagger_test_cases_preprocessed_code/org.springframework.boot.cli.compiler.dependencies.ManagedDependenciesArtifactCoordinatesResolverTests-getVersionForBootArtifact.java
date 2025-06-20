@Test public void getVersionForBootArtifact() throws Exception {
assertThat(this.resolver.getVersion("spring-boot-something"),equalTo("1"));
}