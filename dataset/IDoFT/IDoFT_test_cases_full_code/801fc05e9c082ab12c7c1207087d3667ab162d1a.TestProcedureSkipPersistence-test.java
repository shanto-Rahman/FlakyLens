@Test public void test() throws Exception {
  TestProcedure proc=new TestProcedure();
  long procId=procExecutor.submitProcedure(proc);
  htu.waitFor(30000,() -> proc.isWaiting());
  ProcedureTestingUtility.restart(procExecutor);
  htu.waitFor(30000,() -> {
    Procedure<?> p=procExecutor.getProcedure(procId);
    return p.isWaiting() || p.isFinished();
  }
);
  assertFalse(procExecutor.isFinished(procId));
  ProcedureTestingUtility.restart(procExecutor);
  htu.waitFor(30000,() -> procExecutor.isFinished(procId));
  Procedure<ProcEnv> p=procExecutor.getResult(procId);
  assertTrue(p.isSuccess());
}
