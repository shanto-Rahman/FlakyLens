@Test public void customLayout() throws Exception {
assertThat(hasEntry(file,"test/" + libJarFile.getName()),equalTo(true));
assertThat(getManifest(file).getMainAttributes().getValue("Main-Class"),equalTo("testLauncher"));
}