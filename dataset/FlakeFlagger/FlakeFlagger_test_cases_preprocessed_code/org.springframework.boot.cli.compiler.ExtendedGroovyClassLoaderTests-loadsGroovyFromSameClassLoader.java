@Test public void loadsGroovyFromSameClassLoader() throws Exception {
assertThat(c1.getClassLoader(),sameInstance(c2.getClassLoader()));
}