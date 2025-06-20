@Test public void outputPipe(){
if (Platform.getNativePlatform().isUnix()) {
assertFalse(libc.pipe(outputPipe) < 0);//IT//RW
assertNotSame(-1,outputPipe[0]);
assertNotSame(-1,outputPipe[1]);
pid=posix.posix_spawnp("echo",actions,Arrays.asList("echo","bar"),emptyEnv);//RW
assertTrue(pid != -1);
posix.libc().close(outputPipe[1]);//RW
long nbytes=posix.libc().read(outputPipe[0],output,output.remaining());//RW
assertEquals(4L,nbytes);
assertEquals("bar",new String(bytes).trim());
}
}