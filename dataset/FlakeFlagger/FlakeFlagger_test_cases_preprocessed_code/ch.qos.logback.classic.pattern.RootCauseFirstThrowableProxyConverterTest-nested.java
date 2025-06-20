@Test public void nested(){
assertThat(result).startsWith("java.lang.Exception: nesting level=0");
assertThat(positionOf("nesting level=0").in(result)).isLessThan(positionOf("nesting level =1").in(result));
assertThat(positionOf("nesting level =1").in(result)).isLessThan(positionOf("nesting level =2").in(result));
}