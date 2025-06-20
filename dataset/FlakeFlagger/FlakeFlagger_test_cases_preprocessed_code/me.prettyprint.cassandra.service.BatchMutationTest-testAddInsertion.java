@Test public void testAddInsertion(){
assertEquals(1,mutationMap.get(StringSerializer.get().toByteBuffer("key1")).size());
assertEquals(2,mutationMap.get(StringSerializer.get().toByteBuffer("key1")).get("Standard1").size());
}