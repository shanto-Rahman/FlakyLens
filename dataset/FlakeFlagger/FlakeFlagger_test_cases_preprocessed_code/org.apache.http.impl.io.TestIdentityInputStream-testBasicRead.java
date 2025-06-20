@Test public void testBasicRead() throws Exception {
Assert.assertEquals(2,instream.read(tmp,0,tmp.length));
Assert.assertEquals('a',tmp[0]);
Assert.assertEquals('b',tmp[1]);
Assert.assertEquals('c',instream.read());
Assert.assertEquals(-1,instream.read(tmp,0,tmp.length));
Assert.assertEquals(-1,instream.read());
Assert.assertEquals(-1,instream.read(tmp,0,tmp.length));
Assert.assertEquals(-1,instream.read());
}