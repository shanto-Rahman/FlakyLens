@Test public void get(){
assertEquals(2,CollectionUtils.get((Object)collectionA,2));
assertEquals(2,CollectionUtils.get((Object)collectionA.iterator(),2));
assertEquals(map.entrySet().iterator().next(),CollectionUtils.get((Object)map,0));
}