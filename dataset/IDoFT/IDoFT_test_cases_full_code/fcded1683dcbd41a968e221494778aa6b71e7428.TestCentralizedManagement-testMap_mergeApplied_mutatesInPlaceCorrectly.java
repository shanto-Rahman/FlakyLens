@Test public void testMap_mergeApplied_mutatesInPlaceCorrectly(){
  Map<String,Object> testMap=new HashMap<>();
  testMap.put("key","${TEST.string}");
  CentralizedManagement.mergeMap(testMap);
  Assert.assertEquals("test",testMap.get("key").toString());
}
