/** 
 * @see #27
 */
@Test void writesLinkCorrectly() throws Exception {
assertThat(write(Link.of("location","something"))).isEqualTo(REFERENCE);
}