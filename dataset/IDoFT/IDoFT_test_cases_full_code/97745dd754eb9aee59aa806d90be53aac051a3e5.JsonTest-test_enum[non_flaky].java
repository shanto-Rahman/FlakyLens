@Test public void test_enum(){
  assertEquals("\"K\"",Json.toJson(K.K));
  String expected="{\n" + "   \"name\": \"t\",\n" + "   \"index\": 1\n"+ "}";
  assertJsonEqualsNonStrict(expected,Json.toJson(TT.T));
  assertEquals("\"T\"",Json.toJson(TT.T,JsonFormat.full().ignoreJsonShape()));
}
