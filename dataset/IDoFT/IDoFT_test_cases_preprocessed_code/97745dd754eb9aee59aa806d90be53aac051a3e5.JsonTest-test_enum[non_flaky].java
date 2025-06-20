@Test public void test_enum(){
assertEquals("\"K\"",Json.toJson(K.K));//RW
assertJsonEqualsNonStrict(expected,Json.toJson(TT.T));//RW
assertEquals("\"T\"",Json.toJson(TT.T,JsonFormat.full().ignoreJsonShape()));//RW
}