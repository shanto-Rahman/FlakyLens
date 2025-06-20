@Test public void springBootVersion() throws Exception {
assertThat(actualManifest.getMainAttributes().containsKey(new Attributes.Name("Spring-Boot-Version")),equalTo(true));
}