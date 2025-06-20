@Test public void testBasicEncoding(){
assertTrue("Should contain identifier for Integer IdentifiableEnum",str.contains("\"enumField2\":12345"));
assertTrue("Double quote should be escaped",str.contains("\"String1: '\\\"\""));
assertTrue("Should contain identifier for String IdentifiableEnum",str.contains("strEnumV1"));
assertTrue("Overridden field should be properly serialized",str.contains("\"fieldInBaseClass\":\"Overridden Value\""));
assertFalse("TransientProp shouldn't be encoded",str.contains("TransientProp"));
assertFalse("transientField shouldn't be encoded",str.contains("transientField"));
assertFalse("privateField shouldn't be encoded",str.contains("privateField"));
assertFalse("staticField shouldn't be encoded",str.contains("staticField"));
assertEquals(tb1.publicStrField,tb.publicStrField);
assertTrue(tb.publicTreeMap instanceof TreeMap);
assertTrue(tb.getTreeMap() instanceof TreeMap);
assertTrue(tb.publicLinkedList instanceof LinkedList);
assertTrue(tb.getLinkedList1() instanceof LinkedList);
assertEquals(str,toJSONString(tb1));
}