@Test void equals(){
  Jwt jwt1=Mockito.mock(Jwt.class);
  when(jwt1.getTokenValue()).thenReturn(jwtGenerator.createToken().getTokenValue());
  Jwt jwt2=Mockito.mock(Jwt.class);
  when(jwt2.getTokenValue()).thenReturn(jwtGenerator.createToken().getTokenValue());
  AuthenticationToken cut=new AuthenticationToken(jwt1,null);
  assertEquals(cut,new AuthenticationToken(jwt1,null));
  assertEquals(cut,new AuthenticationToken(jwt2,null));
  assertEquals(new AuthenticationToken(jwt1,singleAuthority),new AuthenticationToken(jwt2,singleAuthority));
  assertEquals(cut.hashCode(),cut.hashCode());
  assertEquals(cut,new AuthenticationToken(jwt1,null));
}
