@Test public void decoratedModelShouldBeThreadSafe() throws Exception {
Assert.assertEquals(expectedModel,factory.create());
}