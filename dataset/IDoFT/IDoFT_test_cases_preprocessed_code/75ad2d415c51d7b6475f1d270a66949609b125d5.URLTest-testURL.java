@Test public void testURL(){
Assert.assertEquals("value1",p1);
Assert.assertEquals("default",p2);
Assert.assertTrue(b1);
Assert.assertTrue(b2);
Assert.assertEquals(10,i1.intValue());
Assert.assertEquals(9,i2.intValue());
Assert.assertEquals("http://localhost:8080/config",uri);
Assert.assertEquals("http://localhost:8080/default/config/1.0/service",identity);
Assert.assertTrue(canServe);
Assert.assertEquals("http://localhost:8080/config?key1=value1&key2=true&key5=10L&key3=10&key4=3.14&nodeType=service&version=1.0&",fullStr);
Assert.assertNotNull(newUrl);
}