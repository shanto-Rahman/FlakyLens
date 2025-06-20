@Test public void get_descriptor_for_property(){
assertThat(propertyDescriptor).isNotNull();
assertThat(propertyDescriptor.getName()).isEqualTo("age");
}