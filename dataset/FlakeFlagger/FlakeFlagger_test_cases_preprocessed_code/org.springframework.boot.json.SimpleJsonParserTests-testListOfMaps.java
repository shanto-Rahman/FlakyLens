@SuppressWarnings("unchecked") @Test public void testListOfMaps(){
assertEquals(2,list.size());
assertEquals(2,((Map<String,Object>)list.get(1)).size());
}