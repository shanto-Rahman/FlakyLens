@Test public void shouldNotChangeTheModelWhenNoTransformersProvided(){
Assert.assertEquals(new WroModel().getGroups(),factory.create().getGroups());
}