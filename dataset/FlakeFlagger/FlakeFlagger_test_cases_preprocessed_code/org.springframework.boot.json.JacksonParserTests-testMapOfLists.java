@SuppressWarnings("unchecked") @Test public void testMapOfLists(){
assertEquals(1,map.size());
assertEquals(2,((List<Object>)map.get("foo")).size());
}