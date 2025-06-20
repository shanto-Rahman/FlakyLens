@SuppressWarnings("unchecked") @Override public boolean ignoreMethodBasedOnFirstArg(String methodName,Object firstArg){
  out.ignoreMethodBasedOnFirstArg(methodName,firstArg);
switch (methodName) {
case "method1":default:    throw new AssertionError();
case "method2":  String text=(String)firstArg;
return Boolean.parseBoolean(text);
case "method3":MockDto dto=(MockDto)firstArg;
return dto.field2 <= 0;
}
}
