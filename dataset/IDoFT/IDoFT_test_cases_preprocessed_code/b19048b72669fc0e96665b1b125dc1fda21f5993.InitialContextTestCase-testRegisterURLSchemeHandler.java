@Test public void testRegisterURLSchemeHandler() throws Exception {
Assert.fail("Precondition: the foobar: scheme should not yet be registered");
Assert.assertTrue("The object should now be provided by our TestObjectFactory",something.startsWith("TestObject:"));
Assert.fail("Should throw an IllegalArgumentException since the associated factory object doesn't match the registration");
Assert.assertEquals("The foobar: scheme should still be registered",something,ictx.lookup("foobar:something"));
Assert.fail("The foobar: scheme should not be registered any more");
}