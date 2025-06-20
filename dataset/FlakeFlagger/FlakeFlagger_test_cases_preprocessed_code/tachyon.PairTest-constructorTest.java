@Test public void constructorTest(){
Assert.assertEquals(obj[j],tPair.getFirst());
Assert.assertEquals(obj[k],tPair.getSecond());
Assert.assertNotSame(obj[k],tPair.getFirst());
Assert.assertNotSame(obj[j],tPair.getSecond());
}