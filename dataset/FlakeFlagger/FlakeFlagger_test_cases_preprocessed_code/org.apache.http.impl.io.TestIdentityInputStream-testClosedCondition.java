@Test public void testClosedCondition() throws Exception {
Assert.assertEquals(0,instream.available());
Assert.assertEquals(-1,instream.read(tmp,0,tmp.length));
Assert.assertEquals(-1,instream.read());
Assert.assertEquals(-1,instream.read(tmp,0,tmp.length));
Assert.assertEquals(-1,instream.read());
}