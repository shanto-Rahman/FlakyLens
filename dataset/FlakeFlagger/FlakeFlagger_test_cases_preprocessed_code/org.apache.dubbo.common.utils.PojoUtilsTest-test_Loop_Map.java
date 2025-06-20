@Test public void test_Loop_Map() throws Exception {
assertSame(map,map.get("m"));
assertEquals("v",ret.get("k"));
assertSame(ret,ret.get("m"));
}