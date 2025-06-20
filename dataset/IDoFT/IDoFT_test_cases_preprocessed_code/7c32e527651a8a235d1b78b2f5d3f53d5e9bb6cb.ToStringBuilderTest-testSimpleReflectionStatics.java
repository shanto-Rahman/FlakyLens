@Test public void testSimpleReflectionStatics(){
assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345]",ReflectionToStringBuilder.toString(instance1,null,false,true,SimpleReflectionStaticFieldsFixture.class));
assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345]",ReflectionToStringBuilder.toString(instance1,null,true,true,SimpleReflectionStaticFieldsFixture.class));
assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345]",this.toStringWithStatics(instance1,null,SimpleReflectionStaticFieldsFixture.class));
assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345]",this.toStringWithStatics(instance1,null,SimpleReflectionStaticFieldsFixture.class));
}