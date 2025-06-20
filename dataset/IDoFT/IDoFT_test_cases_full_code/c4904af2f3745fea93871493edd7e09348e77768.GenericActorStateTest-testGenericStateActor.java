/** 
 * Ensures that is possible save and restore the state with parametrized states.
 */
@Test public void testGenericStateActor() throws ExecutionException, InterruptedException {
  Stage stage1=createStage();
  assertEquals(0,fakeDatabase.values().size());
  final Point p1=new Point();
  p1.x=1;
  p1.y=2;
  Actor.getReference(GenActor.class,"300").setPoint(p1).join();
  stage1.stop().join();
  Stage stage2=createStage();
  Point p2=Actor.getReference(GenActor.class,"300").getPoint().join();
  assertEquals(1,p2.x);
  assertEquals(2,p2.y);
  assertEquals("{\"data\":{\"x\":1,\"y\":2}}",fakeDatabase.values().stream().findFirst().get().toString());
}
