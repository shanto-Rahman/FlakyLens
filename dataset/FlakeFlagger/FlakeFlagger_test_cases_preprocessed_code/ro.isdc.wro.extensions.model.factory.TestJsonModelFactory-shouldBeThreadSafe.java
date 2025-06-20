@Test public void shouldBeThreadSafe() throws Exception {
Assert.assertEquals(expected,factory.create());
}