/** 
 * @see #63
 */
@Test void serializesPagedResource() throws Exception {
  assertThat(mapper.writeValueAsString(setupAnnotatedPagedResources())).isEqualTo(ANNOTATED_PAGED_RESOURCES);
}
