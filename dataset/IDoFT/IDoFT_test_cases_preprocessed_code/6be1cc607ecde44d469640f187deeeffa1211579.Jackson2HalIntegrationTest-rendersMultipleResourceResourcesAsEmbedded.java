@Test void rendersMultipleResourceResourcesAsEmbedded() throws Exception {
assertThat(mapper.writeValueAsString(resources)).isEqualTo(LIST_EMBEDDED_RESOURCE_REFERENCE);
}