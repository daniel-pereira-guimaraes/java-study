package java_study;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptStudy {
	
	public static void main(String[] args) throws ScriptException {
		nashornExample();
	}
	
	private static void nashornExample() throws ScriptException {
		MiscStudy.printMethodName();
		final String engineName = "Nashorn";
		final ScriptEngineManager engineManager = new ScriptEngineManager();
		final ScriptEngine engine = engineManager.getEngineByName(engineName);
		final Bindings bind = engine.getBindings(ScriptContext.ENGINE_SCOPE);
		bind.put("msg", "Hello JavaScript!");
		final String script = 
				"print(msg); " +
				"var a = 5; " +
				"var b = 10; " +
				"var c = a + b; " +
				"print('a: ' + a); " +
				"print('b: ' + b); " +
				"print('c: ' + c); " +
				"print('Goodbye!');";
		engine.eval(script);
		System.out.println();
	}

}
