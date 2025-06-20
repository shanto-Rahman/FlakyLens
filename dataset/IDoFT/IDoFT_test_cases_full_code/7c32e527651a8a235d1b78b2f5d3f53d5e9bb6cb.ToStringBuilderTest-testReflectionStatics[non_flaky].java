/** 
 * Tests ReflectionToStringBuilder.toString() for statics.
 */
@Test public void testReflectionStatics(){
  final ReflectionStaticFieldsFixture instance1=new ReflectionStaticFieldsFixture();
  assertEquals(this.toBaseString(instance1) + "[instanceInt=67890,instanceString=instanceString,staticInt=12345,staticString=staticString]",ReflectionToStringBuilder.toString(instance1,null,false,true,ReflectionStaticFieldsFixture.class));
  assertEquals(this.toBaseString(instance1) + "[instanceInt=67890,instanceString=instanceString,staticInt=12345,staticString=staticString,staticTransientInt=54321,staticTransientString=staticTransientString,transientInt=98765,transientString=transientString]",ReflectionToStringBuilder.toString(instance1,null,true,true,ReflectionStaticFieldsFixture.class));
  assertEquals(this.toBaseString(instance1) + "[instanceInt=67890,instanceString=instanceString,staticInt=12345,staticString=staticString]",this.toStringWithStatics(instance1,null,ReflectionStaticFieldsFixture.class));
  assertEquals(this.toBaseString(instance1) + "[instanceInt=67890,instanceString=instanceString,staticInt=12345,staticString=staticString]",this.toStringWithStatics(instance1,null,ReflectionStaticFieldsFixture.class));
}
