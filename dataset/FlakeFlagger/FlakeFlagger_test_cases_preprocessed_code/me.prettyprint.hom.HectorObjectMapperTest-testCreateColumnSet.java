@Test public void testCreateColumnSet(){
assertNull("id should not have been added to column collection",colMap.get("id"));
assertEquals(obj.getLongProp1(),(long)LongSerializer.get().fromBytes(colMap.get("lp1").getValue()));
assertEquals(obj.getLongProp2(),LongSerializer.get().fromBytes(colMap.get("lp2").getValue()));
assertEquals(obj.getIntProp1(),(int)IntegerSerializer.get().fromBytes(colMap.get("ip1").getValue()));
assertEquals(obj.getIntProp2(),IntegerSerializer.get().fromBytes(colMap.get("ip2").getValue()));
assertEquals(obj.isBoolProp1(),BooleanSerializer.get().fromBytes(colMap.get("bp1").getValue()));
assertEquals(obj.getBoolProp2(),BooleanSerializer.get().fromBytes(colMap.get("bp2").getValue()));
assertEquals(obj.getStrProp(),StringSerializer.get().fromBytes(colMap.get("sp").getValue()));
assertEquals(obj.getUuidProp(),UUIDSerializer.get().fromBytes(colMap.get("up").getValue()));
assertEquals(obj.getDateProp(),DateSerializer.get().fromBytes(colMap.get("dp").getValue()));
assertEquals("somebytes",new String(BytesArraySerializer.get().fromBytes(colMap.get("bytes").getValue())));
assertEquals(obj.getSerialProp(),ObjectSerializer.get().fromBytes(colMap.get("serialProp").getValue()));
assertEquals(2,obj.getAnonymousProps().size());
assertEquals(obj.getAnonymousProp("foo"),StringSerializer.get().fromBytes(colMap.get("foo").getValue()));
assertEquals(obj.getAnonymousProp("rice"),StringSerializer.get().fromBytes(colMap.get("rice").getValue()));
}