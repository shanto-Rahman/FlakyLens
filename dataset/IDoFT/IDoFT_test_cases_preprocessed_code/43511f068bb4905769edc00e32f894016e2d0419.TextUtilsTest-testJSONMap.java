@Test public void testJSONMap(){
assertEquals("[\"A\",{\"1\":\"bar\",\"foo\":2},\"B\"]",TextUtils.joinJSON(Arrays.asList("A",map,"B")));
}