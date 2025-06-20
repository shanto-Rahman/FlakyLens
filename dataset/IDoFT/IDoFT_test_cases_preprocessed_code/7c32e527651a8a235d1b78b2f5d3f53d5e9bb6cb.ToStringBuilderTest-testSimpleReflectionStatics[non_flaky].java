@Test public void testSimpleReflectionStatics(){
assertEquals(this.toBaseString(instance1) + "[staticInt=12345,staticString=staticString]",ReflectionToStringBuilder.toString(instance1,null,false,true,SimpleReflectionStaticFieldsFixture.class));
assertEquals(this.toBaseString(instance1) + "[staticInt=12345,staticString=staticString]",ReflectionToStringBuilder.toString(instance1,null,true,true,SimpleReflectionStaticFieldsFixture.class));
assertEquals(this.toBaseString(instance1) + "[staticInt=12345,staticString=staticString]",this.toStringWithStatics(instance1,null,SimpleReflectionStaticFieldsFixture.class));
assertEquals(this.toBaseString(instance1) + "[staticInt=12345,staticString=staticString]",this.toStringWithStatics(instance1,null,SimpleReflectionStaticFieldsFixture.class));
}