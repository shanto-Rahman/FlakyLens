@Test public void dontRecompressZips() throws Exception {
assertThat(jarFile.getEntry("lib/" + nestedFile.getName()).getMethod(),equalTo(ZipEntry.STORED));
assertThat(jarFile.getEntry("test/nested.jar").getMethod(),equalTo(ZipEntry.STORED));
}