/** 
 * @see #142
 */
@Test void rendersMultipleCuries() throws Exception {
assertThat(getCuriedObjectMapper(provider).writeValueAsString(resources)).isEqualTo(MULTIPLE_CURIES_DOCUMENT);
}