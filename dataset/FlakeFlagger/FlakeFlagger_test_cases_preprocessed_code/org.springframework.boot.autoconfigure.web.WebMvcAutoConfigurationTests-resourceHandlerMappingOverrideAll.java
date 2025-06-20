@Test public void resourceHandlerMappingOverrideAll() throws Exception {
assertThat(mappingLocations.get("/**").size(),equalTo(1));
assertThat(mappingLocations.get("/**").get(0),equalTo((Resource)new ClassPathResource("/foo/")));
}