/** 
 * Tests ReflectionToStringBuilder.toString() for statics.
 */
@Test public void testReflectionStatics(){
assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]",ReflectionToStringBuilder.toString(instance1,null,false,true,ReflectionStaticFieldsFixture.class));
assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,staticTransientString=staticTransientString,staticTransientInt=54321,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]",ReflectionToStringBuilder.toString(instance1,null,true,true,ReflectionStaticFieldsFixture.class));
assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]",this.toStringWithStatics(instance1,null,ReflectionStaticFieldsFixture.class));
assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]",this.toStringWithStatics(instance1,null,ReflectionStaticFieldsFixture.class));
}