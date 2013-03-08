/**
 * Field of array type 
 * @param {list<Field>} s -- array of fields (of scalar, array or object type)
 */

function ArrayValue(s, root) {
	var self = this;
	self.array = function () { return true; }
	
	var fields = map(s, function (x,i) {
						return new Property(i, x, true);
				});
	
	self._storage = ko.observableArray(fields);
	
	/**
	 *	Elements of the array 
	 */				
	self.elements = ko.computed(function () {
		return self._storage();
	})
	
	/**
	 *	Clones array field 
	 */
	self.clone = function () {
		return new ArrayValue(map(s, function (x) { return x.clone(); }));
	}
	
	/**
	 *  For the moment we consider all arrays as value types  
	 */
	self.isReference = function () { return false; }

	/**
	 *  Returns true iff any child has an error 
	 */
	self.hasError = ko.computed(function () {
		return any(self._storage(), function (x) { return x.impl().hasError(); })
	})

	/**
	 *  expanded representation of the array 
	 */
	self.expanded = self._storage;
}
