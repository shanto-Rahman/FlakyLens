/** 
 * Asserts    {@link ExternalContextsNavigableSet#getParentExternalContext(ServiceName)}
 * @throws Exception
 */
@Test public void testGetParentContext() throws Exception {
assertNull(set.getParentExternalContext(nameA));
assertNull(set.getParentExternalContext(nameP));
assertNotNull(set.getParentExternalContext(namePC));
assertEquals(nameP,set.getParentExternalContext(namePC));
assertNull(set.getParentExternalContext(nameZ));
}