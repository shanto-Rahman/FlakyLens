/** 
 * @see #1216
 */
@Test void testAllIanaLinkRelationsHaveStringConstant(){
assertThat(linkRelations).containsExactlyElementsOf(stringConstants);
}