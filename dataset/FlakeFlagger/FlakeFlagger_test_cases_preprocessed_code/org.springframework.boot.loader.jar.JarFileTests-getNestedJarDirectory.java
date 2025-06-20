@Test public void getNestedJarDirectory() throws Exception {
assertThat(entries.nextElement().getName(),equalTo("9.dat"));
assertThat(entries.hasMoreElements(),equalTo(false));
assertThat(inputStream.read(),equalTo(9));
assertThat(inputStream.read(),equalTo(-1));
assertThat(url.toString(),equalTo("jar:" + this.rootJarFile.toURI() + "!/d!/"));
assertThat(((JarURLConnection)url.openConnection()).getJarFile(),sameInstance(nestedJarFile));
}