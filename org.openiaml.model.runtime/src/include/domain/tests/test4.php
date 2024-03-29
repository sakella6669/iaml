<?php

// this one doesn't autosave, but is a new instance
class DomainIterator_News_rbtbtr22d extends DefaultDomainIterator {

	private function __construct() {
		$this->schema = DomainType_News::getInstance();
		$this->source = DomainSource_NewsDB::getInstance();
		$this->order_by = null;
		$this->order_ascending = true;
		$this->query = "";
		$this->autosave = false;
		$this->is_new = true;
	}

	// the current instance
	static $instance = null;
	public static function getInstance() {
		if (self::$instance == null) {
			self::$instance = new DomainIterator_News_rbtbtr22d();
		}
		return self::$instance;
	}

	public function constructArgs() {
		return array(
			// no args
		);
	}

	public function getOffset() {
		throw new IamlDomainException("Cannot get the offset for a new object: " . get_class($this));
	}

	public function setOffset($value) {
		throw new IamlDomainException("Cannot set the offset for a new object: " . get_class($this));
	}

	public function getNewInstanceID($key) {
		if (!isset($_SESSION["newid_$key"]) || $_SESSION["newid_$key"] === null) {
			return null;
		}

		return $_SESSION["newid_$key"];
	}

	public function setNewInstanceID($key, $id) {
		$_SESSION["newid_$key"] = $id;
	}

}

echo "[test 4] ";
ob_start();
{
	// get the current instance
	$instance = DomainIterator_News_rbtbtr22d::getInstance();

	// print it out
	echo "1:\n";
	printit($instance->toArray());

	// set some values
	$instance->getAttributeInstance(DomainAttribute_News_Title::getInstance())->setValue("new title");
	echo "2:\n";
	printit($instance->toArray());

	// don't save it
	$instance->reload();
	echo "3:\n";
	printit($instance->toArray());

	// set it again
	$instance->getAttributeInstance(DomainAttribute_News_Title::getInstance())->setValue("another title");
	echo "4:\n";
	printit($instance->toArray());

	// save it
	$instance->save();
	echo "5:\n";
	printit($instance->toArray());

	// and reload it
	$instance->reload();
	echo "6:\n";
	printit($instance->toArray());

	// create a new one
	$instance->createNew();
	echo "7:\n";
	printit($instance->toArray());

	// set it
	$instance->getAttributeInstance(DomainAttribute_News_Title::getInstance())->setValue("a new title");
	echo "8:\n";
	printit($instance->toArray());

	// save it
	$instance->save();
	echo "9:\n";
	printit($instance->toArray());

}

$result = ob_get_contents();
ob_end_clean();

// check the results are as expected
compareTestResults($result, "expected4.txt");
