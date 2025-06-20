@Test public void loadPackageName() throws Exception {
assertThat(loaded,equalTo(1));
assertTrue(this.registry.containsBean("myComponent"));
}