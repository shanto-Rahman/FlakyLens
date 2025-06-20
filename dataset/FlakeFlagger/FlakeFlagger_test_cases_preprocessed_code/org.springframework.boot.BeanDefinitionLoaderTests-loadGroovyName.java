@Test public void loadGroovyName() throws Exception {
assertThat(loaded,equalTo(1));
assertTrue(this.registry.containsBean("myGroovyComponent"));
}