@Test void redundancyReduction(){
  assertAll(() -> assertEquals(new CompilerFlags(setOf("-a","-b"),listOf(),null,null),new CompilerFlags(setOf(),listOf("-a","-b"),null,null)),() -> assertEquals(new CompilerFlags(setOf("-a","-b","-c"),listOf("-a","-b"),null,null),new CompilerFlags(setOf("-c"),listOf("-a","-b"),null,null)));
}
