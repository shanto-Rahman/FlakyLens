@Test public void loadClass() throws Exception {
assertThat(loaded,equalTo(1));
assertTrue(this.registry.containsBean("myComponent"));
}