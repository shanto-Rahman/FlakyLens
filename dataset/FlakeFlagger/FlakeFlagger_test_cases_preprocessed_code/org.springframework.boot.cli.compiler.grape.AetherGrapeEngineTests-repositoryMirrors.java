@Test public void repositoryMirrors(){
assertEquals(1,repositories.size());
assertEquals("central-mirror",repositories.get(0).getId());
}