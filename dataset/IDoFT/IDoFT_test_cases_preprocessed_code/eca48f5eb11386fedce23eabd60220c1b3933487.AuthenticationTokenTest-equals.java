@Test void equals(){
assertEquals(cut,new AuthenticationToken(jwt1,null));
assertEquals(cut,new AuthenticationToken(jwt2,null));
assertEquals(new AuthenticationToken(jwt1,singleAuthority),new AuthenticationToken(jwt2,singleAuthority));
assertEquals(cut.hashCode(),cut.hashCode());
assertEquals(cut,new AuthenticationToken(jwt1,null));
}