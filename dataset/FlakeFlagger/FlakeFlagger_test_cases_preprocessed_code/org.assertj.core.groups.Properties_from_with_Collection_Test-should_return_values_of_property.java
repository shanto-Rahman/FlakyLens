@Test public void should_return_values_of_property(){
ages.add(yoda.getAge());//RW
when(propertySupport.propertyValues(propertyName,Integer.class,employees)).thenReturn(ages);//RW
assertSame(ages,properties.from(employees));//RW
}