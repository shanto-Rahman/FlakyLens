/** 
 * @see #27
 * @throws Exception
 */
@Test void inlinesContent() throws Exception {
assertThat(write(resource)).isEqualTo(REFERENCE);
}