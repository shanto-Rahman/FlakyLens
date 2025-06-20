@Test public void paging(){
assertEquals(Arrays.asList("Anton","Barbara"),limit);
assertEquals(Arrays.asList("Barbara","John","Robert"),offset);
assertEquals(Arrays.asList("Barbara","John"),limitAndOffset);
}