<?php

class GmfTestCase {
	var $runner;
	public function setup($runner) {
		$this->runner = $runner;
	}
	protected function fail($message) {
		$this->runner->fail($message);
	}
	protected function pass($message) {
		$this->runner->pass($message);
	}

	// for subclasses to override
	public function run() {
		fatal("no run() specified in " . get_class($this));
	}

	protected function toArray($xml) {
		$r = array();

		if (is_array($xml)) {
			foreach ($xml as $k => $v) {
				$r["$k"] = "$v";
			}
		}

		return $r;
	}

	protected function assert($condition, $message = "expected(true), got(false)") {
		if (!$condition) {
			$this->fail($message);
		} else {
			$this->pass($message);
		}
	}

	protected function assertInArray($needle, $haystack, $message = "") {
		if (!$message) {
			$message = "expected '$needle' in '$haystack'";
		}
		$this->assert(in_array($needle, $haystack), $message);
	}

	protected function assertEquals($a, $b, $message = "") {
		// force to string
		if ($a instanceof SimpleXMLElement)
			$a = "$a";
		if ($b instanceof SimpleXMLElement)
			$b = "$b";

		if (!$message) {
			$message = "expected 'a', got '$b'";
		}
		$this->assert($a == $b, $message);
	}
}
