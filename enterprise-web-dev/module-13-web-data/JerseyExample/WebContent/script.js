/**
 * script.js
 */
console.log("Working `script.js` import");

function partySizeChanged(n) {
	console.log(`User has attempted to change party size to ${n}`);
	if (n > 10 || n < 1) {
		alert("Please indicate a party size of no less than 1 and no greater than 10");
	}
}