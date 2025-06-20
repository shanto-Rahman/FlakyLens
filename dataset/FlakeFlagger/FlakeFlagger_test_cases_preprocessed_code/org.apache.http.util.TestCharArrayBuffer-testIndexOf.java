@Test public void testIndexOf(){
Assert.assertEquals(4,buffer.indexOf(':'));
Assert.assertEquals(-1,buffer.indexOf(','));
Assert.assertEquals(4,buffer.indexOf(':',-1,11));
Assert.assertEquals(4,buffer.indexOf(':',0,1000));
Assert.assertEquals(-1,buffer.indexOf(':',2,1));
}