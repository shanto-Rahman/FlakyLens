@Test public void testEnumQueryParam(){
Assert.assertTrue(output.contains("queryParams?: { target?: TargetEnum; }"));
Assert.assertTrue(output.contains("type TargetEnum = \"Target1\" | \"Target2\""));
}