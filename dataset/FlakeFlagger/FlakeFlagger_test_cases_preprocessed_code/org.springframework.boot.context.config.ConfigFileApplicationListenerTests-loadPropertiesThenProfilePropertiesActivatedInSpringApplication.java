@Test public void loadPropertiesThenProfilePropertiesActivatedInSpringApplication() throws Exception {
assertThat(property,equalTo("fromotherpropertiesfile"));
}