@Test public void testMap_allowNullOverwrite(){
  Map<String,Object> testMap=new HashMap<>();
  testMap.put("key","${TEST.null: value}");
  CentralizedManagement.mergeMap(testMap);
  Assert.assertNull(testMap.get("key"));
}
