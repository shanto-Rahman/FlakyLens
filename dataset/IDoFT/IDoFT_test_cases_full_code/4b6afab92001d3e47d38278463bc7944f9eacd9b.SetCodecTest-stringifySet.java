@Test void stringifySet(){
  SetCodec codec=getCodec(UnpooledByteBufAllocator.DEFAULT);
  String[] strings=stringifySets();
  assertThat(sets).hasSize(strings.length);
  Query query=Query.parse("?");
  for (int i=0; i < sets.length; ++i) {
    ParameterWriter writer=ParameterWriterHelper.get(query);
    codec.encode(sets[i],context()).publishText(writer).as(StepVerifier::create).verifyComplete();
    assertThat(ParameterWriterHelper.toSql(writer)).isEqualTo(strings[i]);
  }
}
