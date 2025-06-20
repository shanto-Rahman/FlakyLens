@Test public void date_assertion_using_custom_date_string_representation(){
assertThat(date).withDateFormat("yyyy/MM/dd").isEqualTo("2003/04/26");
assertThat(date).isEqualTo("2003/04/26");
}