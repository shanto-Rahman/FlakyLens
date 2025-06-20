@Test public void testBufferedHeader() throws Exception {
Assert.assertNotNull(headers);
Assert.assertEquals(1,headers.length);
Assert.assertEquals("header1  : stuff; param1 = value1; param2 = \"value 2\" ",headers[0].toString());
Assert.assertNotNull(elements);
Assert.assertEquals(1,elements.length);
Assert.assertEquals("stuff",elements[0].getName());
Assert.assertEquals(null,elements[0].getValue());
Assert.assertNotNull(params);
Assert.assertEquals(2,params.length);
Assert.assertEquals("param1",params[0].getName());
Assert.assertEquals("value1",params[0].getValue());
Assert.assertEquals("param2",params[1].getName());
Assert.assertEquals("value 2",params[1].getValue());
}