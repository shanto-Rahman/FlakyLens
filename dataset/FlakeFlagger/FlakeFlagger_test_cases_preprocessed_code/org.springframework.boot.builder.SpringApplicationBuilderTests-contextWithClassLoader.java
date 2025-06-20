@Test public void contextWithClassLoader() throws Exception {
assertThat(((SpyApplicationContext)this.context).getClassLoader(),is(equalTo(classLoader)));
}