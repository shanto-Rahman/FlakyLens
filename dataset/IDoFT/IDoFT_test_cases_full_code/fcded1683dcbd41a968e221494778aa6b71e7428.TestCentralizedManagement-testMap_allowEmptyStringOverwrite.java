@Test public void testMap_allowEmptyStringOverwrite(){
  Map<String,Object> testMap=new HashMap<>();
  testMap.put("key","${TEST.emptyString: value}");
  CentralizedManagement.mergeMap(testMap);
  Assert.assertEquals("",testMap.get("key"));
}
