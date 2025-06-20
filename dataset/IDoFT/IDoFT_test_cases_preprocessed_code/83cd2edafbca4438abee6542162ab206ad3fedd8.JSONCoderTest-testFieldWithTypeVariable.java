@Test public void testFieldWithTypeVariable(){
bean.refOfMap.set(new MapBuilder("str1",1).getMap());
assertEquals(json,json1);
}