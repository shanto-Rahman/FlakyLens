@Test public void migrateTest() throws Exception {
Assert.assertFalse(additionalInitialization.extensionAdded);
Assert.assertTrue(model.get(SUBSYSTEM).hasDefined(JacORBExtension.SUBSYSTEM_NAME));
Assert.assertFalse(model.get(SUBSYSTEM).hasDefined(IIOPExtension.SUBSYSTEM_NAME));
Assert.assertTrue(additionalInitialization.extensionAdded);
Assert.assertFalse(model.get(SUBSYSTEM).hasDefined(JacORBExtension.SUBSYSTEM_NAME));
Assert.assertTrue(model.get(SUBSYSTEM).hasDefined(IIOPExtension.SUBSYSTEM_NAME));
Assert.assertTrue(newSubsystem.get("export-corbaloc").equals(new ModelNode(true)));
Assert.assertTrue(newSubsystem.get("confidentiality").equals(new ModelNode("required")));
Assert.assertTrue(newSubsystem.get("iona").equals(new ModelNode(true)));
}