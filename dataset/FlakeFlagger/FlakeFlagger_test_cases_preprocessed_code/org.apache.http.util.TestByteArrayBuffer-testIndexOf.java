@Test public void testIndexOf() throws Exception {
Assert.assertEquals(index1,buffer.indexOf(COLON));
Assert.assertEquals(-1,buffer.indexOf(COMMA));
Assert.assertEquals(index1,buffer.indexOf(COLON,-1,11));
Assert.assertEquals(index1,buffer.indexOf(COLON,0,1000));
Assert.assertEquals(-1,buffer.indexOf(COLON,2,1));
Assert.assertEquals(index2,buffer.indexOf(COLON,index1 + 1,buffer.length()));
}