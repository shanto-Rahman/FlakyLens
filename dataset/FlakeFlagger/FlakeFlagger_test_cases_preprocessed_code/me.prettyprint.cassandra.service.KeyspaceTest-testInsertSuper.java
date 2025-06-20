/** 
 * Test insertion of a supercolumn using insert
 */
@Test public void testInsertSuper() throws IllegalArgumentException, NoSuchElementException, IllegalStateException, HNotFoundException, Exception {
assertNotNull(sc);
assertEquals("testInsertSuper_super",string(sc.getName()));
assertEquals(2,sc.getColumns().size());
assertEquals("testInsertSuper_value",string(sc.getColumns().get(0).getValue()));
}