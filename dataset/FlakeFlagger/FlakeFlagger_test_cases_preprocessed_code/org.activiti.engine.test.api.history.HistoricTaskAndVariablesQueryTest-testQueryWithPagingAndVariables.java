public void testQueryWithPagingAndVariables(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals(1,tasks.size());
assertEquals(2,variableMap.size());
assertEquals("someVariable",variableMap.get("testVar"));
assertEquals(123,variableMap.get("testVar2"));
assertEquals(2,tasks.size());
assertEquals(2,variableMap.size());
assertEquals("someVariable",variableMap.get("testVar"));
assertEquals(123,variableMap.get("testVar2"));
assertEquals(1,tasks.size());
assertEquals(2,variableMap.size());
assertEquals("someVariable",variableMap.get("testVar"));
assertEquals(123,variableMap.get("testVar2"));
assertEquals(0,tasks.size());
}
}