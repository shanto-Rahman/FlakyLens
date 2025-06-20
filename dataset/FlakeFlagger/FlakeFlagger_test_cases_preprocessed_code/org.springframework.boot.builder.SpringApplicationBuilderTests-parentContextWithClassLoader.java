@Test public void parentContextWithClassLoader() throws Exception {
assertThat(((SpyApplicationContext)this.context).getResourceLoader().getClassLoader(),is(equalTo(classLoader)));
}