@Test public void should_throw_illegal_argument_exception_when_extracting_from_null() throws Exception {
assertThat(new CartoonCharacter[]{homer,null}).flatExtracting("children");
}