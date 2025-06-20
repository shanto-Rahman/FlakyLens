@Test void defaulting(){
  assertAll(() -> assertEquals(new CompilerFlags(setOf("-a","-b"),listOf(),null,null),new CompilerFlags(setOf(),listOf("-a","-b"),null,null)),() -> assertEquals(new CompilerFlags(setOf("-a","-b"),listOf("-c","-d"),null,null),new CompilerFlags(setOf(),listOf("-a","-b","-c","-d"),null,null)));
}
