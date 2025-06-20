/** 
 * @see #63
 */
@Test void serializesMultipleAnnotatedResourceResourcesAsEmbedded() throws Exception {
  assertThat(mapper.writeValueAsString(setupAnnotatedResources())).isEqualTo(ANNOTATED_EMBEDDED_RESOURCES_REFERENCE);
}
