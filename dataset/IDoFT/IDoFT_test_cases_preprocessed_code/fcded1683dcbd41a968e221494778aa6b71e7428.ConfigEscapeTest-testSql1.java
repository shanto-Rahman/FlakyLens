@Test public void testSql1(){
Assert.assertEquals("SELECT JSON_VALUE(abc, '$.foo.bar') FROM def",passwordMap.get("sql1"));
}