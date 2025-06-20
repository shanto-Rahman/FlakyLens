@Test(expected=ConcurrentModificationException.class) public void testConcurrentModification(){
assertEquals(4,map.size());
}