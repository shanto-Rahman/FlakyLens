@Test public void should_throw_error_if_PropertyDescriptor_cannot_invoke_read_method() throws Exception {
PropertyDescriptor real=getProperty("age",yoda);//RW
when(descriptor.invokeReadMethod(real,yoda)).thenThrow(thrownOnPurpose);//RW
propertySupport.propertyValues("age",Long.class,employees);//RW
fail("expecting an IntrospectionError to be thrown");
assertSame(thrownOnPurpose,expected.getCause());
String msg=String.format("Unable to obtain the value of the property <'age'> from <%s>",yoda.toString());//RW
assertEquals(msg,expected.getMessage());
}