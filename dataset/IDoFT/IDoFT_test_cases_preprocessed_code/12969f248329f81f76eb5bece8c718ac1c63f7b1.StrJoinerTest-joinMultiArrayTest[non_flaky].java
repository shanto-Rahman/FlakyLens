@Test public void joinMultiArrayTest(){
Assert.assertThat(append.toString(),CoreMatchers.anyOf(CoreMatchers.is("1,2,3,4"),CoreMatchers.is("1,2,4,3")));
}