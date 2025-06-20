@Test public void go() throws IOException, InterruptedException {
if (!isConformingHost()) {
}
for (int i=0; i < NUM_STEPS; i++) //RW
fa.append(String.valueOf(i) + LONG_STR);//RW
Thread.sleep(DELAY);//RW
ResilienceUtil.verify(logfileStr,"^(\\d//RW
}