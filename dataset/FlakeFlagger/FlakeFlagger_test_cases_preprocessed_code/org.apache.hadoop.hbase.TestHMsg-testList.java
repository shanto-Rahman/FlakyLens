public void testList(){
assertEquals(size,msgs.size());
assertNotSame(-1,index);
assertEquals(size - 1,msgs.size());
assertEquals(-1,msgs.indexOf(hmsg));
assertNotSame(-1,msgs.indexOf(hmsg));
}