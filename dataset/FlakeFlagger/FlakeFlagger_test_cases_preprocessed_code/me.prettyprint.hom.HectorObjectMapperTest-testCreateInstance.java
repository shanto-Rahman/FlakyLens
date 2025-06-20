@Test public void testCreateInstance(){
assertEquals(id,obj.getBaseId());
assertEquals(longProp1,obj.getLongProp1());
assertEquals(longProp2,obj.getLongProp2());
assertEquals(intProp1,obj.getIntProp1());
assertEquals(intProp2,obj.getIntProp2());
assertFalse(obj.isBoolProp1());
assertTrue(obj.getBoolProp2());
assertEquals(strProp,obj.getStrProp());
assertEquals(uuidProp,obj.getUuidProp());
assertEquals("somebytes",new String(obj.getBytesProp()));
assertEquals(dateProp.getTime(),obj.getDateProp().getTime());
assertEquals(serialProp,obj.getSerialProp());
assertEquals(extraProp,obj.getAnonymousProp("extra"));
}