@Test public void loadResourceName() throws Exception {
assertThat(loaded,equalTo(1));
assertTrue(this.registry.containsBean("myXmlComponent"));
}