@Test public void loadXmlResource() throws Exception {
assertThat(loaded,equalTo(1));
assertTrue(this.registry.containsBean("myXmlComponent"));
}