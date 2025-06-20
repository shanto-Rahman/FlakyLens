@Test public void should_pass_if_actual_not_has_same_type_as_other(){
objects.assertHasSameClassAs(info,actual,"Yoda");//RW
verify(failures).failure(info,shouldHaveSameClass(actual,"Yoda"));//RW
}