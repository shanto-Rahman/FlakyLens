/** 
 * @see #100
 */
@Test void rendersAllExtraRFC8288Attributes() throws Exception {
  RepresentationModel<?> resourceSupport=new RepresentationModel<>();
  resourceSupport.add(Link.of("localhost","self").withHreflang("en").withTitle("the title").withType("the type").withMedia("the media").withDeprecation("/customers/deprecated"));
  assertThat(mapper.writeValueAsString(resourceSupport)).isEqualTo(SINGLE_WITH_ALL_EXTRA_ATTRIBUTES);
}
