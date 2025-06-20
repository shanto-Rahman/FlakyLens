@Test public void testSimpleMapWithNull(){
Assert.fail("Unexpected success");
Assert.assertEquals("Encountered null map value for key NullKeyValue while marshalling attribute value {M: {KeyValue={S: ValueValue,}, NullKeyValue=null},}",npe.getMessage());
}