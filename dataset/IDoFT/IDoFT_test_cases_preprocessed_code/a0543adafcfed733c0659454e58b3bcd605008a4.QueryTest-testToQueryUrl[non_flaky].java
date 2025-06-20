@Test public void testToQueryUrl(){
assertEquals(excepted,Query.newInstance().initParams(parameters).toQueryUrl());
}