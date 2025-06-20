@Test public void testGetNextSet2(){
assertEquals(String.valueOf(i),i <= 31 ? 31 : 33,array.getNextSet(i));
assertEquals(String.valueOf(i),32,array.getNextSet(i));
}