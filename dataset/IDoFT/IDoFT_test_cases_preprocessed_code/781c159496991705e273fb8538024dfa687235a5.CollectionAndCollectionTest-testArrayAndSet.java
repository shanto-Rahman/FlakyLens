@Test public void testArrayAndSet(){
assertEquals(intSetValue.size(),intArray.length);
assertEquals(intSetValue.iterator().next(),intArray[0]);
assertEquals(integerSetValue.size(),integerArray.length);
assertEquals(integerSetValue.iterator().next(),integerArray[0]);
assertEquals(intSetValueOther.size(),intArray.length);
assertEquals(intSetValueOther.iterator().next().intValue(),intArray[0]);
assertEquals(integerSetValueOther.size(),integerArray.length);
assertEquals(bigDecimalSetValue.size(),bigDecimalArray.length);
assertEquals(bigDecimalSetValue.iterator().next(),bigDecimalArray[0]);
assertEquals(bigIntegerSetValue.size(),bigIntegerArray.length);
assertEquals(bigIntegerSetValue.iterator().next(),bigIntegerArray[0]);
assertEquals(modelSetValue.size(),modelArray.length);
assertEquals(modelSetValue.iterator().next(),modelArray[0]);
assertEquals(modelSetValueOther.size(),modelArray.length);
assertEquals(modelSetValueOther.iterator().next().getI(),modelArray[0].getI());
}