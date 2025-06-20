@Test public void testToString(){
Assert.assertEquals("http://somehost",host1.toString());
Assert.assertEquals("http://somehost",host2.toString());
Assert.assertEquals("http://somehost",host3.toString());
Assert.assertEquals("http://somehost:8888",host4.toString());
Assert.assertEquals("myhttp://somehost",host5.toString());
Assert.assertEquals("myhttp://somehost:80",host6.toString());
}