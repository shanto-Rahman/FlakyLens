@Test public void testToHostString(){
Assert.assertEquals("somehost",host1.toHostString());
Assert.assertEquals("somehost",host2.toHostString());
Assert.assertEquals("somehost",host3.toHostString());
Assert.assertEquals("somehost:8888",host4.toHostString());
}