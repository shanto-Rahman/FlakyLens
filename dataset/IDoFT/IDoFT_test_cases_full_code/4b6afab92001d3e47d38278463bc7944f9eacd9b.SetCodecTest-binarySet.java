@Test void binarySet(){
  SetCodec codec=getCodec(UnpooledByteBufAllocator.DEFAULT);
  ByteBuf[] binaries=binarySets(CharCollation.clientCharCollation().getCharset());
  assertThat(sets).hasSize(binaries.length);
  for (int i=0; i < sets.length; ++i) {
    AtomicReference<ByteBuf> buf=new AtomicReference<>();
    ByteBuf sized=sized(binaries[i]);
    try {
      merge(Flux.from(codec.encode(sets[i],context()).publishBinary())).doOnNext(buf::set).as(StepVerifier::create).expectNext(sized).verifyComplete();
    }
  finally {
      sized.release();
      Optional.ofNullable(buf.get()).ifPresent(ByteBuf::release);
    }
  }
}
