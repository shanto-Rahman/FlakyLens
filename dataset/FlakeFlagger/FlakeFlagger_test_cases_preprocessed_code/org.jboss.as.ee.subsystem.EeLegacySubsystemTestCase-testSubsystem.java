@Test public void testSubsystem() throws Exception {
assertEquals("org.jboss.logging",globalModules.require(0).require(NAME).asString());
assertEquals("main",globalModules.require(0).require(SLOT).asString());
assertEquals("org.apache.log4j",globalModules.require(1).require(NAME).asString());
assertTrue(globalModules.require(1).require(ANNOTATIONS).asBoolean());
assertTrue(globalModules.require(1).require(META_INF).asBoolean());
assertFalse(globalModules.require(1).require(SERVICES).asBoolean());
assertFalse(subsystem.require(ANNOTATION_PROPERTY_REPLACEMENT).asBoolean());
assertTrue(subsystem.require(EAR_SUBDEPLOYMENTS_ISOLATED).asBoolean());
assertTrue(subsystem.require(JBOSS_DESCRIPTOR_PROPERTY_REPLACEMENT).asBoolean());
assertFalse(subsystem.require(SPEC_DESCRIPTOR_PROPERTY_REPLACEMENT).asBoolean());
}