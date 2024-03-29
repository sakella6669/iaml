
/**
 * A basic implementation of some XQuery functions.
 */
function xquery_function_callback(function_name, arg0, arg1, arg2, arg3) {

  switch (function_name.toLowerCase()) {
    case "op_numeric_add":
      if (typeof arg0 == "undefined") arg0 = 0;
      if (typeof arg1 == "undefined") arg1 = 0;

      assert_is_numeric(function_name, arg0);
      assert_is_numeric(function_name, arg1);
      return (arg0 * 1) + (arg1 * 1);

    case "op_numeric_subtract":
      if (typeof arg0 == "undefined") arg0 = 0;
      if (typeof arg1 == "undefined") arg1 = 0;

      assert_is_numeric(function_name, arg0);
      assert_is_numeric(function_name, arg1);
      return (arg0 * 1) - (arg1 * 1);

    case "op_numeric_multiply":
      if (typeof arg0 == "undefined") arg0 = 0;
      if (typeof arg1 == "undefined") arg1 = 0;

      assert_is_numeric(function_name, arg0);
      assert_is_numeric(function_name, arg1);
      return (arg0 * 1) * (arg1 * 1);

    case "op_numeric_divide":
      if (typeof arg0 == "undefined") arg0 = 0;
      if (typeof arg1 == "undefined") arg1 = 0;

      assert_is_numeric(function_name, arg0);
      assert_is_numeric(function_name, arg1);
      if (arg1 === 0)
        throw new IamlJavascriptException("Division by zero");
      if (arg1 === 0.0)
        return (arg0 * 1) < 0 ? "-INF" : "INF";
      return (arg0 * 1) / (arg1 * 1);

    case "fn_abs":
      if (typeof arg0 == "undefined") arg0 = 0;

      assert_is_numeric(function_name, arg0);
      return xquery_abs(arg0);

    case "fn_floor":
      if (typeof arg0 == "undefined") arg0 = 0;

      assert_is_numeric(function_name, arg0);
      return Math.floor(arg0);

    case "fn_concat":
      if (typeof arg0 == "undefined") arg0 = "";
      if (typeof arg1 == "undefined") arg1 = "";

      return arg0 + "" + arg1;

    case "fn_substring":
      if (typeof arg0 == "undefined") arg0 = "";
      if (typeof arg1 == "undefined") arg1 = "";

      assert_is_string(function_name, arg0);
      if (typeof arg2 == "undefined") {
        assert_is_numeric(function_name, arg1);
        return arg0.substr(arg1);
      } else {
        assert_is_numeric(function_name, arg1);
        assert_is_numeric(function_name, arg2);
        return arg0.substr(arg1, arg2);
      }

    case "fn_contains":
      if (typeof arg0 == "undefined") arg0 = "";
      if (typeof arg1 == "undefined") arg1 = "";

      assert_is_string(function_name, arg0);
      // "If the value of arg2 is the zero-length string, then the function returns true."
      if (arg1 === "")
        return true;
      // "If the value of arg1 is the zero-length string, the function returns false."
      if (arg0 === "")
        return false;
      return arg0.indexOf(arg1) != -1;

    case "fn_codepoint_equal":
      if (typeof arg0 == "undefined") arg0 = "";
      if (typeof arg1 == "undefined") arg1 = "";

      return arg0 === arg1;

    case "op_numeric_equal":
      if (typeof arg0 == "undefined") arg0 = 0;
      if (typeof arg1 == "undefined") arg1 = 0;

      assert_is_numeric(function_name, arg0);
      assert_is_numeric(function_name, arg1);
      return arg0 == arg1;

    case "op_numeric_less_than":
      if (typeof arg0 == "undefined") arg0 = 0;
      if (typeof arg1 == "undefined") arg1 = 0;

      assert_is_numeric(function_name, arg0);
      assert_is_numeric(function_name, arg1);
      return arg0 < arg1;

    case "op_numeric_greater_than":
      if (typeof arg0 == "undefined") arg0 = 0;
      if (typeof arg1 == "undefined") arg1 = 0;

      assert_is_numeric(function_name, arg0);
      assert_is_numeric(function_name, arg1);
      return arg0 > arg1;

    case "fn_not":
      if (typeof arg0 == "undefined") arg0 = 0;

      return !make_into_boolean(arg0);

    default:
      throw new IamlJavascriptException("No XQuery function '" + function_name + "' has been defined.");
  }

}

function assert_is_numeric(function_name, argument_value) {
  if (isNaN(parseFloat(argument_value))) {
    throw new IamlJavascriptException("XQuery function '" + function_name + "' expected a numeric argument: got '" + argument_value + "'");
  }
}

function assert_is_string(function_name, argument_value) {
  if ((typeof argument_value) != "string") {
    throw new IamlJavascriptException("XQuery function '" + function_name + "' expected a string argument: got '" + argument_value + "'");
  }
}

function xquery_abs($n) {
	return $n > 0 ? $n : -$n;
}
