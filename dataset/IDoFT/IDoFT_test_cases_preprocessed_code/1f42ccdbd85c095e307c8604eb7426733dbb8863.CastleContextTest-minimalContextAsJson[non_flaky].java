@Test public void minimalContextAsJson(){
Assertions.assertThat(parser.parse(contextJson)).isEqualTo(parser.parse(expected));
}