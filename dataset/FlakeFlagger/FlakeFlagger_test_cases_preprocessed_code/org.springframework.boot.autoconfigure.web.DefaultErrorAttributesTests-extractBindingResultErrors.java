@Test public void extractBindingResultErrors() throws Exception {
assertThat(attributes.get("message"),equalTo((Object)("Validation failed for " + "object='objectName'. Error count: 1")));
assertThat(attributes.get("errors"),equalTo((Object)bindingResult.getAllErrors()));
}