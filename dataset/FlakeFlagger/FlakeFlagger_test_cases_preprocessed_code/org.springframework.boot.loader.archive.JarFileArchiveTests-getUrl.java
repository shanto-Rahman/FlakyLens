@Test public void getUrl() throws Exception {
assertThat(url.toString(),equalTo("jar:" + this.rootJarFileUrl + "!/"));
}