@Test @SuppressWarnings("deprecation") public void modifiableImmutableCollections(){
  ModifiableMutableImmutableCollection m=ModifiableMutableImmutableCollection.create();
  m.addA("a");
  m.addA("b","c");
  m.addB("d","e");
  m.putC("x",1);
  m.putC("y",2);
  check(m.a()).isA(ImmutableCollection.class);
  check(m.b()).isA(ImmutableCollection.class);
  check(m.c()).isA(ImmutableMultimap.class);
  check(m.d()).isA(ImmutableMap.class);
  check(m.a()).isOf("a","b","c");
  check(m.b()).isOf("d","e");
  check(m.c().values()).hasContentInAnyOrder(1,2);
  check(m.c().keySet()).hasContentInAnyOrder("x","y");
  check(m.d().isEmpty());
  m.clear();
  check(m.a()).isEmpty();
  check(m.b()).isEmpty();
  check(m.c().entries()).isEmpty();
  check(m.d().entrySet()).isEmpty();
}
