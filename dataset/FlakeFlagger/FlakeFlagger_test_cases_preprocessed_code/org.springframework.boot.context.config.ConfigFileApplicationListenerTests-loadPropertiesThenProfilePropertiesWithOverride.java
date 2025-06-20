@Test public void loadPropertiesThenProfilePropertiesWithOverride() throws Exception {
assertThat(property,equalTo("fromotherpropertiesfile"));
assertThat(property,equalTo("fromprofilepropertiesfile"));
}