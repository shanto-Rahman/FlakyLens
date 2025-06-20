public void testQueryWithPagingAndVariables(){
assertEquals(1,tasks.size());
assertEquals(3,variableMap.size());
assertEquals("someVariable",variableMap.get("testVar"));
assertEquals(123,variableMap.get("testVar2"));
assertEquals("This is a binary variable",new String((byte[])variableMap.get("testVarBinary")));
assertEquals(2,tasks.size());
assertEquals(3,variableMap.size());
assertEquals("someVariable",variableMap.get("testVar"));
assertEquals(123,variableMap.get("testVar2"));
assertEquals("This is a binary variable",new String((byte[])variableMap.get("testVarBinary")));
assertEquals(1,tasks.size());
assertEquals(3,variableMap.size());
assertEquals("someVariable",variableMap.get("testVar"));
assertEquals(123,variableMap.get("testVar2"));
assertEquals("This is a binary variable",new String((byte[])variableMap.get("testVarBinary")));
assertEquals(0,tasks.size());
}