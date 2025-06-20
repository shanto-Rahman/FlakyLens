@Test public void clear(){
assertEquals(template,cache.get(key));
assertNull(cache.get(key));
}