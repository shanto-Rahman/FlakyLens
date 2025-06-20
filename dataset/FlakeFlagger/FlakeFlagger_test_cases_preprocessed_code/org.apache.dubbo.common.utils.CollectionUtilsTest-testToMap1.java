@Test public void testToMap1() throws Exception {
assertTrue(CollectionUtils.toMap().isEmpty());
assertEquals(expected,CollectionUtils.toMap("a",1,"b",2,"c",3));
}