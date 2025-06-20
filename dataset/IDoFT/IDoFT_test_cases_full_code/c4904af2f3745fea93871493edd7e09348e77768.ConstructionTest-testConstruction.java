@Test public void testConstruction() throws Exception {
  final Stage stage=new Stage.Builder().extensions(new TestConstructionExtension()).build();
  try {
    stage.start().join();
    final TestConstruction actor=Actor.getReference(TestConstruction.class,"0");
    assertEquals(OTHER_ID,actor.getId().get());
  }
  finally {
    stage.stop().join();
  }
}
