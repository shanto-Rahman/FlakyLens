@Test public void should_fail_if_actual_is_not_in_array_according_to_custom_comparison_strategy(){
objectsWithCustomComparisonStrategy.assertIsIn(info,"Luke",values);//RW
verify(failures).failure(info,shouldBeIn("Luke",values,customComparisonStrategy));//RW
}