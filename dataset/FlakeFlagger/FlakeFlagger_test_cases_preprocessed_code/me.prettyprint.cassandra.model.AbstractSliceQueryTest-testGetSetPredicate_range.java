@Test public void testGetSetPredicate_range(){
assertNull(p.getColumn_names());
assertNotNull(range);
assertArrayEquals(bytes("1"),range.getStart());
assertArrayEquals(bytes("100"),range.getFinish());
assertEquals(10,range.getCount());
}