package java_study;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class ScriptStudy {

	public static void main(String[] args) throws ScriptException {
		nashornExample();
		rhinoCalcExample1();
		rhinoCalcExample2();
		rhinoCalcExample3();
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
	private static <T> T rhinoCalc(String script, Map<String, ? extends Object> params, String returnVar) {
		Context context = ContextFactory.getGlobal().enterContext();
		try {
			final Scriptable scope = context.initStandardObjects();
			if (params != null) {
				for (Entry<String, ? extends Object> param : params.entrySet()) {
					ScriptableObject.putProperty(scope, param.getKey(), param.getValue());
				}
			}
			Object result = context.evaluateString(scope, script, null, 0, null);
			if (returnVar != null) {
				result = ScriptableObject.getProperty(scope, returnVar);
			}
			return (T) result;
		} finally {
			Context.exit();
		}
	}

	private static <T> T rhinoCalc(String script, Map<String, ? extends Object> params) {
		return rhinoCalc(script, params, null);
	}
	
	private static <T> T rhinoCalc(String script) {
		return rhinoCalc(script, null, null);
	}
	
	private static void rhinoCalcExample1() {
		MiscStudy.printMethodName();
		final String script = "20 + Math.log(5)";
		final Double result = rhinoCalc(script);
		System.out.println("Script: " + script);
		System.out.println("Result: " + result);
		System.out.println();
	}
	
	private static void rhinoCalcExample2() {
		MiscStudy.printMethodName();
		
		final String script = "a + Math.log(b)";
		final Map<String, Double> params = new HashMap<>();

		params.put("a", 5.0);
		params.put("b", 2.0);
	
		final Double result = rhinoCalc(script, params);
		
		System.out.println("Script: " + script);
		System.out.println("Params:");
		params.forEach((k, v) -> System.out.println("\t" + k + " = " + v));
		System.out.println("Result: " + result);
		System.out.println();
	}

	private static void rhinoCalcExample3() {
		MiscStudy.printMethodName();
		final String script = 
				"var total = p.getPrice() * qtd;" +
				"var out = java.lang.System.out;" +
				"out.println('Name: ' + p.getName());" +
				"out.println('Price: ' + p.getPrice());" +
				"out.println('Quantity: ' + qtd);" +
				"out.println('Total: ' + total);";
		final Product product = new Product(1L, "Mouse", 10.0, 5);
		final Map<String, Object> params = new HashMap<>();
		params.put("p", product);
		params.put("qtd", 5);
		final Double total = rhinoCalc(script, params, "total");
		System.out.println("Result: " + total);
		System.out.println();
	}
	
}
