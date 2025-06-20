@Test public void requestHeaders() throws IOException, InterruptedException {
assertEquals("f",connection.getRequestProperty("D"));//ET
assertEquals("f",connection.getRequestProperty("d"));//ET
Map<String,List<String>> requestHeaders=connection.getRequestProperties();//ET
assertEquals(newSet("e","f"),new HashSet<String>(requestHeaders.get("D")));
assertEquals(newSet("e","f"),new HashSet<String>(requestHeaders.get("d")));
fail("Modified an unmodifiable view.");
fail("Modified an unmodifiable view.");
connection.setRequestProperty(null,"j");//ET
fail();
fail();
connection.setRequestProperty("NullValue",null);//ET
assertNull(connection.getRequestProperty("NullValue"));//ET
assertNull(connection.getRequestProperty("AnotherNullValue"));//ET
fail("Set header after connect");
connection.setRequestProperty("P","q");//ET
fail("Set header after connect");
connection.getRequestProperties();//ET
fail();
}