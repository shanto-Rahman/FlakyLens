/** 
 * Tests ReflectionToStringBuilder.toString() for statics.
 */
@Test public void testInheritedReflectionStatics(){
  final InheritedReflectionStaticFieldsFixture instance1=new InheritedReflectionStaticFieldsFixture();
  assertEquals(this.toBaseString(instance1) + "[staticInt2=67890,staticString2=staticString2]",ReflectionToStringBuilder.toString(instance1,null,false,true,InheritedReflectionStaticFieldsFixture.class));
  assertEquals(this.toBaseString(instance1) + "[staticInt2=67890,staticString2=staticString2,staticInt=12345,staticString=staticString]",ReflectionToStringBuilder.toString(instance1,null,false,true,SimpleReflectionStaticFieldsFixture.class));
  assertEquals(this.toBaseString(instance1) + "[staticInt2=67890,staticString2=staticString2,staticInt=12345,staticString=staticString]",this.toStringWithStatics(instance1,null,SimpleReflectionStaticFieldsFixture.class));
  assertEquals(this.toBaseString(instance1) + "[staticInt2=67890,staticString2=staticString2,staticInt=12345,staticString=staticString]",this.toStringWithStatics(instance1,null,SimpleReflectionStaticFieldsFixture.class));
}
