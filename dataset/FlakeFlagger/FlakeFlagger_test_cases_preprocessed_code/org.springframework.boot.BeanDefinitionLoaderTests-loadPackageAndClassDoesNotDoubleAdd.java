@Test public void loadPackageAndClassDoesNotDoubleAdd() throws Exception {
assertThat(loaded,equalTo(1));
assertTrue(this.registry.containsBean("myComponent"));
}