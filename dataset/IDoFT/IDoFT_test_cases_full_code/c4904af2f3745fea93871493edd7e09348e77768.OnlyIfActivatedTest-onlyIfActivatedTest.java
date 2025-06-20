@Test public void onlyIfActivatedTest(){
  clock.stop();
  OnlyIfActivated only=Actor.getReference(OnlyIfActivated.class,"234");
  only.doSomethingSpecial("A").join();
  only.doSomethingSpecial("A").join();
  only.doSomethingSpecial("A").join();
  only.doSomethingSpecial("A").join();
  only.doSomethingSpecial("A").join();
  Assert.assertEquals(0,OnlyIfActivatedActor.accessCount);
  only.makeActiveNow().join();
  only.doSomethingSpecial("A").join();
  only.doSomethingSpecial("A").join();
  only.doSomethingSpecial("A").join();
  only.doSomethingSpecial("A").join();
  only.doSomethingSpecial("A").join();
  assertEquals(5,OnlyIfActivatedActor.accessCount);
  clock.incrementTime(10,TimeUnit.MINUTES);
  only.doSomethingSpecial("A").join();
  assertEquals(6,OnlyIfActivatedActor.accessCount);
  clock.incrementTime(10,TimeUnit.MINUTES);
  stage.cleanup().join();
  only.doSomethingSpecial("A").join();
  assertEquals(6,OnlyIfActivatedActor.accessCount);
}
