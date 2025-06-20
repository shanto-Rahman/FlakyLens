@Test public void testBasicProperties(){
Assert.assertNotNull(message.getParams());
Assert.assertNotNull(message.headerIterator());
Assert.assertNotNull(headers);
Assert.assertEquals(0,headers.length);
}