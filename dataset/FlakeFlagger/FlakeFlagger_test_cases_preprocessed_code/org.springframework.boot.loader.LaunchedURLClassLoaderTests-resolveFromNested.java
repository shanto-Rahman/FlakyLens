@Test public void resolveFromNested() throws Exception {
assertThat(resource.toString(),equalTo(url + "nested.jar!/3.dat"));
assertThat(resource.openConnection().getInputStream().read(),equalTo(3));
}