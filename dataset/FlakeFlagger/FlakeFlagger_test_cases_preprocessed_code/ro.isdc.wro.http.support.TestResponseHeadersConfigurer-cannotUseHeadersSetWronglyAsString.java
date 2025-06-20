@Test(expected=WroRuntimeException.class) public void cannotUseHeadersSetWronglyAsString(){
assertEquals(2,map.size());
assertEquals("v1",map.get("h1"));
assertEquals("v2",map.get("h2"));
}