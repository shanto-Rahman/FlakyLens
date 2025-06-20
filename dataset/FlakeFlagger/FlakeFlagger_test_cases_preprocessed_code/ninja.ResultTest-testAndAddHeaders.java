@Test public void testAndAddHeaders(){
assertEquals(2,result.getHeaders().size());
assertEquals("value1",result.getHeaders().get("header1"));
assertEquals("value2",result.getHeaders().get("header2"));
}