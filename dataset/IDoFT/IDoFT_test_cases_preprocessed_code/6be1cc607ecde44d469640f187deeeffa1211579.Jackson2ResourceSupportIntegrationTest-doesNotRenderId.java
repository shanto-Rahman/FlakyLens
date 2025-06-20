/** 
 * @see #27
 */
@Test void doesNotRenderId() throws Exception {
assertThat(write(resourceSupport)).isEqualTo(REFERENCE);
}