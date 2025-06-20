@Test public void getToolsJar() throws Exception {
assertThat(jarUrl.toString(),endsWith(".jar"));
assertThat(new File(jarUrl.toURI()).exists(),equalTo(true));//RO
}