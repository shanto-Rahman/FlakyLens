@Test public void testInitializeSaveLoad(){
assertEquals(o1.getBaseId(),o2.getBaseId());
assertEquals(o1.getIntProp1(),o2.getIntProp1());
assertEquals(o1.isBoolProp1(),o2.isBoolProp1());
assertEquals(o1.getLongProp1(),o2.getLongProp1());
}