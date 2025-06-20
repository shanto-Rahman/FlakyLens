@Test public void testSql2(){
  Map<String,Object> passwordMap=Config.getInstance().getJsonMapConfigNoCache("password");
  Assert.assertEquals("SELECT JSON_VALUE(abc, '$.foo.bar') FROM def",passwordMap.get("sql2"));
}
