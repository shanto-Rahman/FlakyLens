@Test public void test(){
Assert.assertEquals(str,e.fromByteBuffer(e.toByteBuffer(str)));
}