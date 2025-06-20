@Test public void resourceHandlerMappingOverrideWebjars() throws Exception {
assertThat(mappingLocations.get("/webjars/**").size(),equalTo(1));
assertThat(mappingLocations.get("/webjars/**").get(0),equalTo((Resource)new ClassPathResource("/foo/")));
}