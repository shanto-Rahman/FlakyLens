@Test public void testSql1(){
  Map<String,Object> passwordMap=Config.getInstance().getJsonMapConfigNoCache("password");
  Assert.assertEquals("SELECT JSON_VALUE(abc, '$.foo.bar') FROM def",passwordMap.get("sql1"));
}
