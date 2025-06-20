@Test public void testInsertAndGetAndRemove() throws IllegalArgumentException, NoSuchElementException, IllegalStateException, HNotFoundException, Exception {
assertNotNull(col);
assertEquals("testInsertAndGetAndRemove_value_" + i,value);
fail("the value should already being deleted");
}