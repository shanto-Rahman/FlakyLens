@Test public void createEntryUrl() throws Exception {
assertThat(url.toString(),equalTo("jar:" + this.rootJarFile.toURI() + "!/1.dat"));
assertThat(jarURLConnection.getJarFile(),sameInstance(this.jarFile));
assertThat(jarURLConnection.getJarEntry(),sameInstance(this.jarFile.getJarEntry("1.dat")));
assertThat(jarURLConnection.getContentLength(),equalTo(1));
assertThat(jarURLConnection.getContent(),instanceOf(InputStream.class));
assertThat(jarURLConnection.getContentType(),equalTo("content/unknown"));
}