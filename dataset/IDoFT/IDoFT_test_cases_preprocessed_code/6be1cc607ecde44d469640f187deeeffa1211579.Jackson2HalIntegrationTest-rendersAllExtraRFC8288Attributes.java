/** 
 * @see #100
 */
@Test void rendersAllExtraRFC8288Attributes() throws Exception {
assertThat(mapper.writeValueAsString(resourceSupport)).isEqualTo(SINGLE_WITH_ALL_EXTRA_ATTRIBUTES);
}