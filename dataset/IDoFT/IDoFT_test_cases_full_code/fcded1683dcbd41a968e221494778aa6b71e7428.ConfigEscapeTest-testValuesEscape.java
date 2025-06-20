@Test public void testValuesEscape(){
  Map<String,Object> passwordMap=Config.getInstance().getJsonMapConfigNoCache("password");
  Assert.assertEquals("def$g",passwordMap.get("value"));
}
