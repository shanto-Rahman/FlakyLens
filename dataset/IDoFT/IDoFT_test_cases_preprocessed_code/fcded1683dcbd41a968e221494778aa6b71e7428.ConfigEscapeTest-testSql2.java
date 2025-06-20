@Test public void testSql2(){
Assert.assertEquals("SELECT JSON_VALUE(abc, '$.foo.bar') FROM def",passwordMap.get("sql2"));
}