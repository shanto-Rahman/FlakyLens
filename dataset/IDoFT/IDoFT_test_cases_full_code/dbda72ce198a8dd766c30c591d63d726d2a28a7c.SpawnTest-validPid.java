@Test public void validPid(){
  if (Platform.getNativePlatform().isUnix()) {
    long pid=-1;
    try {
      pid=posix.posix_spawnp("true",emptyActions,Arrays.asList("true"),emptyEnv);
      assertTrue(pid != -1);
    }
  finally {
      if (pid != -1)       posix.libc().waitpid((int)pid,null,0);
    }
  }
}
