@Test public void loadGroovyResource() throws Exception {
assertThat(loaded,equalTo(1));
assertTrue(this.registry.containsBean("myGroovyComponent"));
}