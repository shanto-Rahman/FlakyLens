@Test public void getNestedJarFile() throws Exception {
assertThat(entries.nextElement().getName(),equalTo("META-INF/"));
assertThat(entries.nextElement().getName(),equalTo("META-INF/MANIFEST.MF"));
assertThat(entries.nextElement().getName(),equalTo("3.dat"));
assertThat(entries.nextElement().getName(),equalTo("4.dat"));
assertThat(entries.nextElement().getName(),equalTo("\u00E4.dat"));
assertThat(entries.hasMoreElements(),equalTo(false));
assertThat(inputStream.read(),equalTo(3));
assertThat(inputStream.read(),equalTo(-1));
assertThat(url.toString(),equalTo("jar:" + this.rootJarFile.toURI() + "!/nested.jar!/"));
assertThat(conn.getJarFile(),sameInstance(nestedJarFile));
assertThat(conn.getJarFileURL().toString(),equalTo("jar:" + this.rootJarFile.toURI() + "!/nested.jar"));
}