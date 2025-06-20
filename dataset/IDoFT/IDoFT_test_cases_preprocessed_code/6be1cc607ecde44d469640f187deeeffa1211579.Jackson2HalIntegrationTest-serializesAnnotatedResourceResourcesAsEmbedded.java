/** 
 * @see #47, #60
 */
@Test void serializesAnnotatedResourceResourcesAsEmbedded() throws Exception {
assertThat(mapper.writeValueAsString(resources)).isEqualTo(ANNOTATED_EMBEDDED_RESOURCE_REFERENCE);
}