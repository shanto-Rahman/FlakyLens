@Test public void getNestedArchive() throws Exception {
assertThat(nested.getUrl().toString(),equalTo("jar:" + this.rootJarFileUrl + "!/nested.jar!/"));
}