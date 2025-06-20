@Test public void onlyIfActivatedTest(){
Assert.assertEquals(0,OnlyIfActivatedActor.accessCount);
assertEquals(5,OnlyIfActivatedActor.accessCount);
assertEquals(6,OnlyIfActivatedActor.accessCount);
assertEquals(6,OnlyIfActivatedActor.accessCount);
}