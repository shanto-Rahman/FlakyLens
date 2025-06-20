@Test public void shouldBeThreadSafe() throws Exception {
Assert.assertEquals(expectedModel,factory.create());
}