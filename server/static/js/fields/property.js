/**
 * Represents a property or a field of an object
 * Contains label to display and reference to a concrete field implementation (scalar, array or object)
 * @param {string} name  -- displayable label
 * @param {ObjectValue|ArrayValue|ScalarValue} value -- concrete implementation of the field
 * @param {bool} expanded -- are property fields expanded ininitially
 */
function Property(name, value, expanded) {
	var self = this;
	self.scalar = value.scalar;
	self.array  = value.array;
	self.object = value.object;
	
	/**
	 *	Returns name of the field
	 */
	self.name = function () { return name; }
	
	/**
	 * Concrete implementation of the field 
	 */
	self.impl = function (){ return value; }
	
	/**
	 *	Property name to display 
	 */
	self.displayLabel = ko.computed(function () { 
		return name + (self.scalar ? self.impl().changedSign() : ""); 
	});
	
	/**
	 *  Clones the property 
	 */
	self.clone = function () {
		return new Property(name, value.clone(), expanded);
	}
	
	/**
	 *	Returns a JSON representation of the field: (name, value) 
	 */
	self.toJSON = function () {
		return [name, value.toJSON()];
	}
	
	/**
	 * Error message for the field if any 
	 */
	self.errorMessage = ko.computed(function () {
		return self.scalar ? self.impl().errormsg() : "";
	});
	
	/**
	 *	Returns true if there are changes in the field 
	 */
	self.hasChanged = function () {
		return self.scalar && self.impl().hasChanged();
	}
	
	/**
	 *	Returns value to save of the field (for the moment it is only for scalar fields)
	 */
	self.toSave = function () {
		assert(self.scalar);
		return self.impl().validated();
	}
	
	/**
	 *	Returns true if there any errors in the field 
	 */
	self.hasError = ko.computed(function () {
		return self.impl().hasError();
	});
	
	/**
	 *	Returns true iff field row should be rendered with error style 
	 */
	self.hasErrorStyle = ko.computed(function () {
		return self.scalar && self.hasError();
	})
	
	/**
	 *  Returns true iff the fiels can be expanded 
	 */
	self.expandable = ko.computed(function () {
		return !self.scalar && self.impl().expanded().length;
	});
	
	/**
	 *  Returns true if the field is expanded at the moment 
	 */
	self.isExpanded = ko.observable(self.expandable() && expanded);

	/**
	 *	Returns array of expanded field items if in expanded state 
	 */
	self.expandedView = ko.computed(function() {
		return self.isExpanded() ? self.impl().expanded() : [];
	});
	
	/**
	 * 	Sets new value to the field. At the moment server may update only scalar values
 	 * @param {number|string} newvalue
	 */
	self.set = function (newvalue) {
		assert(self.scalar);
		self.impl().set(newvalue);
	}
	
	self.dropHistory = function () {
		if (self.scalar) {
			self.impl().dropHistory();
		} 
	}
}