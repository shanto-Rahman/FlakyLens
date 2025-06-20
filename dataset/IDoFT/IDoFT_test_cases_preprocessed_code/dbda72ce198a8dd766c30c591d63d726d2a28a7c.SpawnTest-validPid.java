@Test public void validPid(){
if (Platform.getNativePlatform().isUnix()) {
pid=posix.posix_spawnp("true",emptyActions,Arrays.asList("true"),emptyEnv);//RW
assertTrue(pid != -1);
if (pid != -1) posix.libc().waitpid((int)pid,null,0);
posix.libc().waitpid((int)pid,null,0);//RW
}
}