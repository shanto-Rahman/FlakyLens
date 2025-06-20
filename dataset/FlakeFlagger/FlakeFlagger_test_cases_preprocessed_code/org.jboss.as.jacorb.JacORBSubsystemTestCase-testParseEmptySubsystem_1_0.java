@Test public void testParseEmptySubsystem_1_0() throws Exception {
Assert.assertEquals(1,operations.size());
Assert.assertEquals(ADD,addSubsystem.get(OP).asString());
Assert.assertEquals(1,addr.size());
Assert.assertEquals(SUBSYSTEM,element.getKey());
Assert.assertEquals(JacORBExtension.SUBSYSTEM_NAME,element.getValue());
}