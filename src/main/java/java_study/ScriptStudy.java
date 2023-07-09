package java_study;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.Scriptable;

public class ScriptStudy {

	public static void main(String[] args) throws ScriptException {
		nashornExample();
		rhinoCalcExample();
	}

	private static void nashornExample() throws ScriptException {
		MiscStudy.printMethodName();
		
		final String engineName = "Nashorn";
		final ScriptEngineManager engineManager = new ScriptEngineManager();
		final ScriptEngine engine = engineManager.getEngineByName(engineName);
		final Bindings bind = engine.getBindings(ScriptContext.ENGINE_SCOPE);
		final String script =
				"print(msg);" +
				"var a = 5;" +
				"var b = 10;" +
				"var c = a + b;" +
				"print('a: ' + a);" +
				"print('b: ' + b);" +
				"print('c: ' + c);" +
				"print('Goodbye!');";
		
		bind.put("msg", "Hello JavaScript!");
		engine.eval(script);
		System.out.println();
	}

	@SuppressWarnings("unchecked")
	private static <T> T rhinoCalc(String script) {
		Context context = ContextFactory.getGlobal().enterContext();
		try {
			final Scriptable scope = context.initStandardObjects();
			return (T) context.evaluateString(scope, script, null, 0, null);
		} finally {
			Context.exit();
		}
	}
	
	private static void rhinoCalcExample() {
		MiscStudy.printMethodName();
		final String script = "20 + Math.log(5)";
		final Double result = rhinoCalc(script);
		System.out.println("Script: " + script);
		System.out.println("Result: " + result);
		System.out.println();
	}

}
