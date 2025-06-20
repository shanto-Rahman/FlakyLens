@SuppressWarnings("unchecked") @Test public void testBindOverlappingNestedMaps() throws Exception {
assertEquals(0,result.getErrorCount());
assertEquals("abc",c.get("d"));
assertEquals("efg",c1.get("d1"));
}