/** 
 * @see #27
 */
@Test void doesNotRenderId() throws Exception {
  RepresentationModel<?> resourceSupport=new RepresentationModel<>();
  resourceSupport.add(Link.of("localhost"));
  assertThat(write(resourceSupport)).isEqualTo(REFERENCE);
}
