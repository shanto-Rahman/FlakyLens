@Test public void testConstructor(){
Assert.assertEquals("somehost",host1.getHostName());
Assert.assertEquals(-1,host1.getPort());
Assert.assertEquals("http",host1.getSchemeName());
Assert.assertEquals("somehost",host2.getHostName());
Assert.assertEquals(8080,host2.getPort());
Assert.assertEquals("http",host2.getSchemeName());
Assert.assertEquals("somehost",host3.getHostName());
Assert.assertEquals(-1,host3.getPort());
Assert.assertEquals("http",host3.getSchemeName());
Assert.assertEquals("somehost",host4.getHostName());
Assert.assertEquals(443,host4.getPort());
Assert.assertEquals("https",host4.getSchemeName());
Assert.fail("IllegalArgumentException should have been thrown");
}