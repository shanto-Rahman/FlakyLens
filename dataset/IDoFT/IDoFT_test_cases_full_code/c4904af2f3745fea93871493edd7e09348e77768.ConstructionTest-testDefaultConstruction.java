@Test public void testDefaultConstruction() throws Exception {
  final Stage stage=new Stage.Builder().build();
  try {
    stage.start().join();
    final TestConstruction actor=Actor.getReference(TestConstruction.class,"0");
    assertEquals(DEFAULT_ID,actor.getId().get());
  }
  finally {
    stage.stop().join();
  }
}
